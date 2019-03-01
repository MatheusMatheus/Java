package model.dao;

import java.util.List;

public interface DAO<T> {
    T findById(Long id);
    T findByField(String fieldName, Object value);
    boolean remove(T entity);
    T save(T entity);
    List<T> getAll();
}
