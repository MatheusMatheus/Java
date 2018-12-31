package farmacia.model.dao;

import java.util.Collection;

public interface Repositorio<T> {
	void inserir(T entidade);

	Collection<T> listar();

	void alterar(T entidade);

	void excluir(T entidade);

	T getById(int id);
}
