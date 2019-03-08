package model;

import java.io.StringReader;
import java.util.Objects;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Funcionario {
	@Id
	private String matricula;
	private String nome;
	private int idade;
	private HistoricoSalarial historicoSalarial;	
	private boolean diretor;
	
	@OneToOne
	@JoinColumn(name = "login_fk")
	private Login login;
	
	private Funcionario superior;
	
	public void setHistoricoSalarial(JsonArray jsonArray) {
		this.historicoSalarial = new HistoricoSalarial().toObject(jsonArray);
	}
	
	public void setHistoricoSalarial(HistoricoSalarial historicoSalarial) {
		this.historicoSalarial = historicoSalarial;
	}
	
	/**
	 * Converte o objeto Java para um objeto JSON
	 * @return Objeto JSON
	 */
	public JsonObject toJson() {
		if(Objects.nonNull(superior)) {
			return Json.createObjectBuilder()
					.add("matricula", this.matricula)
					.add("nome", this.nome)
					.add("idade", this.idade)
					.add("diretor", this.diretor)
					//.add("login", this.login.toJson())
					.add("historico", this.historicoSalarial.toJson())
					.add("superior", this.superior.matricula)
					.build();
		}	
		
		return Json.createObjectBuilder().build();
	}

	
	public Funcionario toObject(String json) {
		
		JsonReader reader = Json.createReader(new StringReader(json));
		JsonObject jsonObject = reader.readObject();
		
		this.setMatricula(jsonObject.getString("matricula"));
		this.setNome(jsonObject.getString("nome"));
		this.setIdade(jsonObject.getInt("idade"));
		this.setDiretor(jsonObject.getBoolean("diretor"));
		//this.setLogin(jsonObject.getJsonObject("login"));
		this.setHistoricoSalarial(jsonObject.getJsonArray("historico"));
		return this;
	}
}
