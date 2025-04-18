package net.younes.framework;

import jakarta.xml.bind.annotation.XmlElement;

public class PropertyConfig {

    private String name;
    private String ref;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
