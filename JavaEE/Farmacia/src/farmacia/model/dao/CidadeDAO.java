package farmacia.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import farmacia.model.Cidade;
import farmacia.model.Estado;

public class CidadeDAO extends DAO<Cidade> {

	@Override
	public void inserir(Cidade cidade) {
		String sql = "insert into cidade (nome, estado_id) values (?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, cidade.getNome());
			statement.setInt(2, cidade.getEstado().getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public Collection<Cidade> listar() {
		String sql = "select * from cidade";
		try (PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery();) {

			Collection<Cidade> cidades = new ArrayList<>();

			while (resultSet.next()) {
				Cidade cidade = new Cidade();
				cidade.setId(Integer.parseInt(resultSet.getString("id")));
				cidade.setNome(resultSet.getString("nome"));
				cidade.setEstado(getEstado(resultSet.getString("estado_id")));
				cidades.add(cidade);
			}
			return cidades;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public void alterar(Cidade cidade) {
		String sql = "update cidade set nome = ?, estado_id = ? where id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, cidade.getNome());
			statement.setInt(2, cidade.getEstado().getId());
			statement.setInt(3, cidade.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Cidade cidade) {
		String sql = "delete from cidade where id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, cidade.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Cidade getById(int id) {
		String sql = "select * from cidade where id = ?";
		ResultSet resultSet = null;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			Cidade cidade = new Cidade();
			
			while (resultSet.next()) {
				cidade.setId(Integer.parseInt(resultSet.getString("id")));
				cidade.setNome(resultSet.getString("nome"));
				Estado estado = getEstado(resultSet.getString("estado_id"));
				cidade.setEstado(estado);
			}

			return cidade;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			fechaResultSet(resultSet);
		}
	}
	
	private Estado getEstado(String idstr) {
		DAO<Estado> dao = new EstadoDAO();
		int id = Integer.parseInt(idstr);
		return dao.getById(id);
	}

}
