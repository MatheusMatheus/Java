package br.com.modelo.dao;

import br.com.modelo.EntidadeBase;

public interface DAO<T extends EntidadeBase> {
    T findById(Long id);
    T findByField(String fieldName, Object value);
    boolean remove(T entity);
    T save(T entity);
}
