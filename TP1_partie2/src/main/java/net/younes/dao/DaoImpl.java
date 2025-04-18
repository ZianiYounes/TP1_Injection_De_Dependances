package net.younes.dao;
import net.younes.annotations.Component;

@Component
public class DaoImpl implements IDao {
    public double getData() {
        return 100;
    }
}