package net.younes.pres;

import net.younes.dao.DaoImpl;
import net.younes.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao); // Injection via setter
        System.out.println("Résultat : " + metier.calcul());
    }
}
