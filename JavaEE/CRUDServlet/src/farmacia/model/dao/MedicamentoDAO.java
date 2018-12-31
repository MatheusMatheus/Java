package farmacia.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import farmacia.model.Laboratorio;
import farmacia.model.Medicamento;

public class MedicamentoDAO extends DAO<Medicamento> {

	public MedicamentoDAO() {
	}

	@Override
	public void inserir(Medicamento medicamento) {
		String sql = "insert into medicamento (nome, validade, laboratorio_id, tipo) values (?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			statement.setString(1, medicamento.getNome());
			statement.setDate(2, java.sql.Date.valueOf(medicamento.getValidade()));
			statement.setInt(3, medicamento.getLaboratorio().getId());
			statement.setString(4, medicamento.getTipo().toString());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		}
	}

	public Collection<Medicamento> getLista() {
		String sql = "select * from medicamento";
		try (PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {

			Collection<Medicamento> medicamentos = new ArrayList<>();

			while (resultSet.next()) {
				Medicamento medicamento = new Medicamento();
				medicamento.setId(resultSet.getInt("id"));
				medicamento.setNome(resultSet.getString("nome"));
				medicamento.setValidade(resultSet.getDate("validade").toLocalDate());
				medicamento.setLaboratorio(getLaboratorio(resultSet.getString("laboratorio_id")));
				medicamentos.add(medicamento);
			}
			return medicamentos;
		} catch (SQLException e) {
			rollback(connection);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void alterar(Medicamento medicamento) {
		String sql = "update medicamento set nome = ?, validade = ?, laboratorio_id = ? where id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, medicamento.getNome());
			statement.setDate(2, java.sql.Date.valueOf(medicamento.getValidade()));
			statement.setInt(3, medicamento.getLaboratorio().getId());
			statement.setInt(4, medicamento.getId());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		}

	}

	@Override
	public void excluir(Medicamento medicamento) {
		String sql = "delete from medicamento where id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, medicamento.getId());
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		}

	}

	@Override
	public Medicamento getById(int id) {
		String sql = "select * from medicamento where id = ?";
		ResultSet resultSet = null;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			Medicamento medicamento = new Medicamento();
			while (resultSet.next()) {
				medicamento.setId(resultSet.getInt("id"));
				medicamento.setNome(resultSet.getString("nome"));
				medicamento.setValidade(resultSet.getDate("validade").toLocalDate());
				medicamento.setLaboratorio(getLaboratorio(resultSet.getString("laboratorio_id")));
			}

			return medicamento;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			fechaResultSet(resultSet);
		}
	}

	private Laboratorio getLaboratorio(String idLab) {
		DAO<Laboratorio> dao = new LaboratorioDAO();
		int id = Integer.parseInt(idLab);
		return dao.getById(id);
	}
}
