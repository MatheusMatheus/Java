package farmacia.model;

public class Laboratorio {
	private int id;
	private String nome;
	private Cidade cidade;
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("ID: " + getId());
		s.append("\nNome: " + getNome());
		s.append("\nCidade: " + getCidade());
		return s.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
