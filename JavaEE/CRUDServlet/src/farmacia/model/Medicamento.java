package farmacia.model;

import java.time.LocalDate;

public class Medicamento {
	private int id;
	private String nome;
	private Laboratorio laboratorio;
	private LocalDate validade;
	private TipoMedicamento tipo;

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("ID: " + getId());
		s.append("\nNome: " + getNome());
		s.append("\nValidade: " + getValidade());
		s.append("\nLaboratorio: " + getLaboratorio());

		return s.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public TipoMedicamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMedicamento tipo) {
		this.tipo = tipo;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

}
