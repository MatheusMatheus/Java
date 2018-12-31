package br.com.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("pessoa")
public class Pessoa {

	@GET("pessoas")
	public List<Pessoa> pessoas() {
		return null;
	}
}
