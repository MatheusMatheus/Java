package br.com.ejb.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.ejb.RemoteGenerico;
import br.com.modelo.Pessoa;
import br.com.modelo.dao.PessoaDAO;

@Stateless
public class PessoaBean implements RemoteGenerico<Pessoa>{

	@Inject
	private PessoaDAO dao;
	
	@Override
	public Pessoa salvar(Pessoa entidade) throws Exception {
		return dao.save(entidade);
		
	}

	@Override
	public void excluir(Pessoa entidade) {
		dao.remove(entidade);
	}

	@Override
	public Pessoa consultarPorId(Long id) {
		return dao.findById(id);
	}

}
