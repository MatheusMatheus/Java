package farmacia.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import farmacia.model.Estado;

public class EstadoDAO extends DAO<Estado> {
	
	public EstadoDAO() {
	}

	@Override
	public void inserir(Estado estado) {
		String sql = "insert into estado (nome, uf) values (?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, estado.getNome());
			statement.setString(2, estado.getUF());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 

	}

	@Override
	public Collection<Estado> getLista() {
		String sql = "select * from estado";
		try (PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
			
			Collection<Estado> estados = new ArrayList<>();
			
			while (resultSet.next()) {
				Estado estado = new Estado();
				estado.setId(Integer.parseInt(resultSet.getString("id")));
				estado.setNome(resultSet.getString("nome"));
				estado.setUF(resultSet.getString("uf"));
				estados.add(estado);
			}
			return estados;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void alterar(Estado estado) {
		String sql = "update estado set nome = ?, uf = ? where id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, estado.getNome());
			statement.setString(2, estado.getUF());
			statement.setInt(3, estado.getId());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 

	}

	@Override
	public void excluir(Estado estado) {
		String sql = "delete from estado where id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, estado.getId());
			
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 
	}

	@Override
	public Estado getById(int id) {
		String sql = "select * from estado where id = ?";
		ResultSet resultSet = null;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			Estado estado = new Estado();
			while (resultSet.next()) {
				estado.setId(Integer.parseInt(resultSet.getString("id")));
				estado.setNome(resultSet.getString("nome"));
				estado.setUF(resultSet.getString("uf"));
			}
			
			return estado;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			fechaResultSet(resultSet);
		}
	}

}
