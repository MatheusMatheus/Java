package model;

import java.io.StringReader;
import java.util.Objects;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Funcionario {
	@Id
	private String matricula;
	private String nome;
	private int idade;
	@OneToOne
	private HistoricoSalarial historicoSalarial;	
	private boolean permissao;
	
	@Enumerated(EnumType.STRING)
	private Cargo cargo;
	
	@OneToOne
	@JoinColumn(name = "login_fk")
	private Login login;
	
	private Funcionario superior;
	
	public Funcionario(String json) {
		toObject(json);
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
					.add("permissao", this.permissao)
					//.add("login", this.login.toJson())
					.add("historico", this.historicoSalarial.toJson())
					.add("superior", this.superior.matricula)
					.add("cargo", cargo.toString())
					.build();
		}	
		
		return Json.createObjectBuilder().build();
	}

	private Funcionario toObject(String json) {
		
		JsonReader reader = Json.createReader(new StringReader(json));
		JsonObject jsonObject = reader.readObject();
		
		this.setMatricula(jsonObject.getString("matricula"));
		this.setNome(jsonObject.getString("nome"));
		this.setIdade(jsonObject.getInt("idade"));
		this.setPermissao(jsonObject.getBoolean("permissao"));
		this.setLogin(jsonObject.getJsonObject("login"));
		this.setHistoricoSalarial(jsonObject.getJsonArray("historico"));
		this.setCargo(Cargo.valueOf(jsonObject.getString("cargo")));
		return this;
	}
	
	public void setLogin(JsonObject jsonObject) {
		Login login = this.login.toObject(jsonObject);
		setLogin(login);
	}
	
	public void setLogin(Login login) {
		login.setFuncionario(this);
	}
	
	public void setHistoricoSalarial(JsonArray jsonArray) {
		this.historicoSalarial = new HistoricoSalarial().toObject(jsonArray);
	}
	
	public void setHistoricoSalarial(HistoricoSalarial historicoSalarial) {
		this.historicoSalarial = historicoSalarial;
	}
}
