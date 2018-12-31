package br.com.ejb.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.ejb.RemoteGenerico;
import br.com.modelo.Livro;
import br.com.modelo.dao.DAO;

@Stateless
public class LivroBean implements RemoteGenerico<Livro> {
	@Inject
	private DAO<Livro> dao;
	
	@Override
	public Livro salvar(Livro entidade) throws Exception {
		return dao.save(entidade);
	}

	@Override
	public void excluir(Livro entidade) {
		dao.remove(entidade);
	}

	@Override
	public Livro consultarPorId(Long id) {
		return dao.findById(id);
	}

}
