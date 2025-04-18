package net.younes.pres;

import net.younes.dao.ext.DaoImplV2;
import net.younes.metier.MetierImpl;

public class Pres2 {
    public static void main(String[] args) {
        DaoImplV2 dao = new DaoImplV2();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao); // Injection via setter
        System.out.println("Résultat : " + metier.calcul());
    }
}
