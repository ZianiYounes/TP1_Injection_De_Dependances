package net.younes.framework;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import net.younes.annotations.*;
import java.beans.Beans;
import java.io.File;
import java.lang.reflect.*;
import java.util.*;

public class XmlApplicationContext implements ApplicationContext {
    private Map<String, Object> beans = new HashMap<>();

    public XmlApplicationContext(String configPath) throws Exception {
        // Utilisation de JAXB pour analyser le fichier XML de configuration
        JAXBContext jaxbContext = JAXBContext.newInstance(BeansConfig.class);  // BeansConfig est la classe qui correspond à la structure du fichier XML
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        BeansConfig beansConfig = (BeansConfig) unmarshaller.unmarshal(new File(configPath));

        // Création des instances de beans à partir du fichier XML
        for (BeanConfig bean : beansConfig.getBeans()) {
            Class<?> clazz = Class.forName(bean.getClassName());
            Object instance = clazz.getDeclaredConstructor().newInstance();
            beans.put(bean.getId(), instance);
        }

        // Injection des dépendances dans les beans
        for (BeanConfig bean : beansConfig.getBeans()) {
            Object beanInstance = beans.get(bean.getId());

            // Injection des propriétés définies dans le fichier XML
            for (PropertyConfig prop : bean.getProperties()) {
                Object dep = beans.get(prop.getRef());
                Field field = beanInstance.getClass().getDeclaredField(prop.getName());
                field.setAccessible(true);
                field.set(beanInstance, dep);
            }

            // Injection via constructeur (si l'annotation @Autowired est utilisée sur le constructeur)
            for (Constructor<?> constructor : beanInstance.getClass().getDeclaredConstructors()) {
                if (constructor.isAnnotationPresent(Autowired.class)) {
                    Parameter[] parameters = constructor.getParameters();
                    List<Object> params = new ArrayList<>();
                    for (Parameter parameter : parameters) {
                        String paramName = parameter.getName();
                        if (beans.containsKey(paramName)) {
                            params.add(beans.get(paramName));
                        }
                    }
                    constructor.setAccessible(true);
                    constructor.newInstance(params.toArray());
                }
            }

            // Injection via setter (si l'annotation @Autowired est utilisée sur un setter)
            for (Method method : beanInstance.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(Autowired.class)) {
                    Parameter[] parameters = method.getParameters();
                    if (parameters.length == 1) {
                        Object dep = beans.get(parameters[0].getName());
                        method.setAccessible(true);
                        method.invoke(beanInstance, dep);
                    }
                }
            }
        }
    }

    // Récupération d'un bean à partir de l'ID
    public Object getBean(String id) {
        return beans.get(id);
    }
}
