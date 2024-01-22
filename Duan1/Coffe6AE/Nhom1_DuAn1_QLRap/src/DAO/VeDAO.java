package DAO;

import Model.Ve;
import java.util.List;


public class VeDAO extends RedFoxCinema<Ve, Object>{

    @Override
    public void insert(Ve entity) {
    }

    @Override
    public void update(Ve entity) {
    }

    @Override
    public void delete(Object id) {
    }

    @Override
    public Ve selectById(Object id) {
        return null;
    }

    @Override
    public List<Ve> selectAll() {
        return null;
    }

    @Override
    protected List<Ve> selectBySql(String sql, Object... args) {
        return null;
    }
    
}
