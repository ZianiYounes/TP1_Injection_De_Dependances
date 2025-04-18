package net.younes.framework;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class BeansConfig {

    private List<BeanConfig> beans;

    @XmlElement(name = "bean")
    public List<BeanConfig> getBeans() {
        return beans;
    }

    public void setBeans(List<BeanConfig> beans) {
        this.beans = beans;
    }
}
