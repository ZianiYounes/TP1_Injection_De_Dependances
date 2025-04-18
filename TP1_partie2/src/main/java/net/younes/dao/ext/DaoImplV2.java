package net.younes.dao.ext;

import net.younes.dao.IDao;

public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version V2 du DAO");
        return 100;
    }
}
