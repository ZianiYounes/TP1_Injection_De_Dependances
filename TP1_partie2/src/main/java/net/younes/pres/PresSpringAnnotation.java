package net.younes.pres;
import net.younes.framework.AnnotationApplicationContext;
import net.younes.metier.IMetier;

public class PresSpringAnnotation {
    public static void main(String[] args) throws Exception {
        AnnotationApplicationContext context = new AnnotationApplicationContext("net.younes");
        IMetier metier = (IMetier) context.getBean("MetierImpl");
        System.out.println("Résultat = " + metier.calcul());
    }
}