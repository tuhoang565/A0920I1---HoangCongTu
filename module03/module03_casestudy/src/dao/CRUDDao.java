package dao;

import java.sql.SQLException;
import java.util.List;

public interface CRUDDao<T> {
    void insert(T t) throws SQLException;
    List<T> getAll();
    T getById(int id);
    void delete(int id) throws SQLException;
    void update(T t) throws SQLException;
    void search(String string);
}
