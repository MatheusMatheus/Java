package br.com.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable, EntidadeBase {
	/* Serial Version UID */
	private static final long serialVersionUID = 5486103235574819424L;
	@Id
	private Serializable id;
	private String nome;

	@Override
	public Serializable getId() {
		return id;
	}

	@Override
	public void setId(Serializable id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



}
