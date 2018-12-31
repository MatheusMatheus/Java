package br.com.teste.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.teste.modelo.Pessoa;
import br.com.teste.service.Service;

@Path("resource")
public class Resource {

	Service s = new Service();
	
	@GET
	@Path("pessoas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getPessoas() {
		return s.getPessoas();
	}
}
