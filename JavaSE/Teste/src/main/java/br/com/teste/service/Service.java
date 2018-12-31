package br.com.teste.service;

import java.util.List;

import br.com.teste.dao.DAO;
import br.com.teste.modelo.Pessoa;

public class Service {

	DAO d = new DAO();
	
	public List<Pessoa> getPessoas() {
		return d.getPessoas();
	}
}
