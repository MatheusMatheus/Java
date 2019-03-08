package rest;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import qualifiers.JWTTokenNeeded;

public interface IFuncionario {
	@GET
	@Path("listar")
	@JWTTokenNeeded
	JsonArray getFuncionarios();
	
	
	@GET
	@Path("{matricula}")
	@JWTTokenNeeded
	JsonObject getFuncionario(@PathParam("matricula")String matricula);
}
