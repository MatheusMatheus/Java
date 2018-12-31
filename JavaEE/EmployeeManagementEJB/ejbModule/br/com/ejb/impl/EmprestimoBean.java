package br.com.ejb.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.ejb.RemoteGenerico;
import br.com.modelo.Emprestimo;
import br.com.modelo.dao.DAO;

@Stateless
public class EmprestimoBean implements RemoteGenerico<Emprestimo> {
	
	@Inject
	private DAO<Emprestimo> dao;

	public Emprestimo salvar(Emprestimo emprestimo) throws Exception {
		return dao.save(emprestimo);
	}

	public Emprestimo consultarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public void excluir(Emprestimo entidade) {
		dao.remove(entidade);
	}
}
