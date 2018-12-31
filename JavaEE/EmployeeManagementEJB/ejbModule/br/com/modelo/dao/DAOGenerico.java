package br.com.modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.modelo.EntidadeBase;

public class DAOGenerico<T extends EntidadeBase> implements DAO<T> {
	private EntityManager entityManager;
	private final Class<T> classe;

	public DAOGenerico(EntityManager entityManager, Class<T> classe) {
		super();
		this.entityManager = entityManager;
		this.classe = classe;
	}

	@Override
	public T findByField(String fieldName, Object value) {
		final String jpql = "select o from " + classe.getSimpleName() + " o " + " where o." + fieldName + " = :"
				+ fieldName;
		TypedQuery<T> query = entityManager.createQuery(jpql, classe);
		query.setParameter(fieldName, value);
		return query.getSingleResult();
	}

	@Override
	public T findById(Long id) {
		return entityManager.find(classe, id);
	}

	@Override
	public boolean remove(T entity) {
		entityManager.remove(entity);
		return true;
	}

	@Override
	public T save(T entity) {
		entityManager.persist(entity);
		return entity;
	}
}
