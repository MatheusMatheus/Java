package rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import qualifiers.JWTTokenNeeded;

public interface IFuncionario {
	@GET
	@Path("listar")
	@JWTTokenNeeded
	Response getFuncionarios();
	
	
	@GET
	@Path("{matricula}")
	@JWTTokenNeeded
	Response getFuncionario(@PathParam("matricula")String matricula);
	
	@POST
	@Path("funcionario")
	@JWTTokenNeeded
	Response inserir(String funcionario);
}
