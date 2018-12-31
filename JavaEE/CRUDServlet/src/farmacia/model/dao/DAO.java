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
		setAutoCommit();
	}
	
	public abstract void inserir(T entidade);

	public abstract Collection<T> getLista();

	public abstract void alterar(T entidade);

	public abstract void excluir(T entidade);
	
	protected void setAutoCommit() {
		try {
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println(e);
		}
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
	
	public void rollback(Connection connection) {
		try {
			connection.rollback();
			System.out.println("Rollback");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
