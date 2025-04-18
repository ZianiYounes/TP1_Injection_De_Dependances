package net.younes.framework;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class BeanConfig {

    private String id;
    private String className;
    private List<PropertyConfig> properties;

    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @XmlElement(name = "property")
    public List<PropertyConfig> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyConfig> properties) {
        this.properties = properties;
    }
}
