package rest;

import javax.json.JsonArray;
import javax.ws.rs.GET;

public interface IFuncionario {
	@GET
	JsonArray getFuncionarios();
}
