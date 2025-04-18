package net.younes.pres;
import net.younes.framework.XmlApplicationContext;
import net.younes.metier.IMetier;

public class PresSpringXML {
    public static void main(String[] args) throws Exception {
        XmlApplicationContext context = new XmlApplicationContext("src/main/resources/config.xml");
        IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("Résultat = " + metier.calcul());
    }
}
