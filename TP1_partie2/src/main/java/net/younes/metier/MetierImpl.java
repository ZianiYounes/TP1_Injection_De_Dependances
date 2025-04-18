package net.younes.metier;

import net.younes.dao.IDao;

public class MetierImpl implements IMetier {

    private IDao dao;

    public MetierImpl() {
        // Constructeur vide requis si on utilise setter ou injection XML
    }

    // Injection via setter
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    // Injection via constructeur (optionnelle)
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData();
        return data * 1.5;
    }
}
