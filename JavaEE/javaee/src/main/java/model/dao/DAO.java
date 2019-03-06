package model.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    T findById(String id);
    T findByField(String fieldName, Object value);
    boolean remove(T entity);
    T save(T entity);
    List<T> getAll();
}
