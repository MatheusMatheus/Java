package br.com.teste.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.teste.modelo.Pessoa;

public class DAO {
	public List<Pessoa> getPessoas() {
		List<Pessoa> objs = new ArrayList<>();
		Pessoa p1 = new Pessoa("123456789", "Teste1", 13, 5000.0);
		Pessoa p2 = new Pessoa("123456789", "Teste2", 14, 4000.0);
		Pessoa p3 = new Pessoa("123456789", "Teste3", 19, 6000.0);
		objs.add(p1);
		objs.add(p2);
		objs.add(p3);
		
		return objs;
	}
}
