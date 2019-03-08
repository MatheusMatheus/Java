package service;

import java.util.List;
import java.util.Objects;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	public Response getFuncionarios() {
		List<Funcionario> funcs = dao.getAll();
		return Response.ok().entity(toJsonArray(funcs)).build();
	}


	@Override
	public Response getFuncionario(String matricula) {
		Funcionario funcionario = dao.findById(matricula);
		if(funcionario != null)
			return Response.ok().entity(toJson(funcionario)).build();
		
		return Response.status(Status.NO_CONTENT).build();
	}
	
	private JsonObject toJson(Funcionario funcionario) {
		return Json.createObjectBuilder()
				   .add("funcionario", funcionario.toJson())
				   .build();		
	}

	private JsonArray toJsonArray(List<Funcionario> funcs) {
		JsonArrayBuilder list = Json.createArrayBuilder();
		funcs.stream()
			 .map(e -> e.toJson())
			 .forEach(list::add);
		return list.build();
	}


	@Override
	public Response inserir(String funcJson) {
		Funcionario funcionario = new Funcionario();
		funcionario = funcionario.toObject(funcJson);
		return Objects.nonNull(dao.save(funcionario)) 
				? Response.ok().build() 
				: Response.notModified().build();
		 
	}
}
