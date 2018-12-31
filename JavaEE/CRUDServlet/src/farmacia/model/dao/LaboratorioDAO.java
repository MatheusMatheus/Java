package farmacia.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import farmacia.model.Cidade;
import farmacia.model.Laboratorio;

public class LaboratorioDAO extends DAO<Laboratorio> {
	
	public LaboratorioDAO() {
	}

	@Override
	public void inserir(Laboratorio laboratorio) {
		String sql = "insert into laboratorio (nome, cidade_id) values (?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, laboratorio.getNome());
			statement.setInt(2, laboratorio.getCidade().getId());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 

	}

	@Override
	public Collection<Laboratorio> getLista() {
		String sql = "select * from estado";
		try (PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {

			Collection<Laboratorio> laboratorios = new ArrayList<>();

			while (resultSet.next()) {
				Laboratorio laboratorio = new Laboratorio();
				laboratorio.setId(Integer.parseInt(resultSet.getString("id")));
				laboratorio.setNome(resultSet.getString("nome"));
				laboratorio.setCidade(getCidade(resultSet.getString("cidade_id")));
				laboratorios.add(laboratorio);
			}
			return laboratorios;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void alterar(Laboratorio laboratorio) {
		String sql = "update laboratorio set nome = ?, cidade_id = ? where id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, laboratorio.getNome());
			statement.setInt(2, laboratorio.getCidade().getId());
			statement.setInt(3, laboratorio.getId());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 
	}

	@Override
	public void excluir(Laboratorio laboratorio) {
		String sql = "delete from laboratorio where id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, laboratorio.getId());
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 

	}

	@Override
	public Laboratorio getById(int id) {
		String sql = "select * from laboratorio where id = ?";
		ResultSet resultSet = null;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			Laboratorio laboratorio = new Laboratorio();
			while (resultSet.next()) {
				laboratorio.setId(Integer.parseInt(resultSet.getString("id")));
				laboratorio.setNome(resultSet.getString("nome"));
				Cidade cidade = getCidade(resultSet.getString("cidade_id"));
				laboratorio.setCidade(cidade);
			}

			return laboratorio;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			fechaResultSet(resultSet);
		}
	}

	private Cidade getCidade(String idCidade) {
		DAO<Cidade> dao = new CidadeDAO();
		int id = Integer.parseInt(idCidade);
		return dao.getById(id);
	}

}
