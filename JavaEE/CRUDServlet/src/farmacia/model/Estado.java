package farmacia.model;

public class Estado {
	private int id;
	private String nome;
	private String UF;

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ID: " + getId());
		stringBuilder.append("\nNome: " + getNome());
		return stringBuilder.toString();
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

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF.substring(0, 2);
	}

}
