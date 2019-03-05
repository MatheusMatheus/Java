package rest;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import qualifiers.JWTTokenNeeded;

public interface IFuncionario {
	@GET
	@Path("listar")
	@JWTTokenNeeded
	JsonArray getFuncionarios();
}
