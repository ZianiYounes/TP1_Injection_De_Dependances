package net.younes.framework;

import net.younes.annotations.*;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;

public class AnnotationApplicationContext implements ApplicationContext {
    private Map<String, Object> beans = new HashMap<>();

    public AnnotationApplicationContext(String basePackage) throws Exception {
        for (Class<?> clazz : getClasses(basePackage)) {
            if (clazz.isAnnotationPresent(Component.class)) {
                Object instance = clazz.getDeclaredConstructor().newInstance();
                Component comp = clazz.getAnnotation(Component.class);
                String id = comp.id().equals("") ? clazz.getSimpleName() : comp.id();
                beans.put(id, instance);
            }
        }

        for (Object bean : beans.values()) {
            for (Field field : bean.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    field.setAccessible(true);
                    Object dep = beans.get(field.getType().getSimpleName());
                    field.set(bean, dep);
                }
            }
        }
    }

    public Object getBean(String id) {
        return beans.get(id);
    }

    private List<Class<?>> getClasses(String packageName) throws Exception {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (resources.hasMoreElements()) {
            File dir = new File(resources.nextElement().toURI());
            for (File file : dir.listFiles()) {
                if (file.getName().endsWith(".class")) {
                    String className = packageName + '.' + file.getName().replace(".class", "");
                    classes.add(Class.forName(className));
                }
            }
        }
        return classes;
    }
}