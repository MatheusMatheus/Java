package farmacia.model;

public class Cidade {
	private int id;
	private String nome;
	private Estado estado;
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ID: " + getId());
		stringBuilder.append("\nNome: " + getNome());
		stringBuilder.append("\nEstado: " + getEstado());
		return stringBuilder.toString();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
