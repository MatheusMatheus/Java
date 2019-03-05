package br.com.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.sessionsbeans.LancadorDeDado;

@ManagedBean
public class DadoMB {
	@EJB
	private LancadorDeDado lancadorDeDado;

	private int resultado;

	public void lancaDado() {
		this.resultado = this.lancadorDeDado.lanca();
	}

	public LancadorDeDado getLancadorDeDado() {
		return lancadorDeDado;
	}

	public void setLancadorDeDado(LancadorDeDado lancadorDeDado) {
		this.lancadorDeDado = lancadorDeDado;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

}
