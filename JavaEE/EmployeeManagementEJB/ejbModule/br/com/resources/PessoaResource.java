package br.com.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.autenticacao.OTPAuthenticated;
import br.com.modelo.DAO;
import br.com.modelo.Pessoa;

@Path("/usuario")
public class PessoaResource {
	@Inject
	private DAO<Pessoa> dao;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@OTPAuthenticated
	public Pessoa findById(@PathParam("id") long id) {
		return dao.findById(id);
	}
}
