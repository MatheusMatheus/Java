package farmacia.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public abstract class DAO<T> {

	protected Connection connection;
	private Repositorio<T> repositorio;

	public DAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void inserir(T entidade) {
		this.repositorio.inserir(entidade);
	}

	public Collection<T> listar() {
		return this.repositorio.listar();
	}

	public void alterar(T entidade) {
		this.repositorio.alterar(entidade);
	}

	public void excluir(T entidade) {
		this.repositorio.excluir(entidade);
	}

	public T getById(int id) {
		return this.repositorio.getById(id);
	}
	
	protected void fechaResultSet(ResultSet resultSet) {
		try {
			if(!resultSet.isClosed())
				resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void rollback() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
