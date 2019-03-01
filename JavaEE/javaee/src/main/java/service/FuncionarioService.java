package service;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Funcionario;
import model.dao.DAO;
import model.dao.DAOFuncinario;
import rest.IFuncionario;

@Path("funcionarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FuncionarioService implements IFuncionario {

	private DAO<Funcionario> dao = new DAOFuncinario();

	@Override
	@GET
	@Path("listar")
	public JsonArray getFuncionarios() {
		List<Funcionario> funcs = dao.getAll();

		return toJson(funcs);
	}

	private JsonArray toJson(List<Funcionario> funcs) {
		JsonArrayBuilder list = Json.createArrayBuilder();
		funcs
			.stream()
			.map(e -> e.toJson())
			.forEach(list::add);
		return list.build();
	}

}
