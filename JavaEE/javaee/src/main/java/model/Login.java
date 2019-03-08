package model;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Login {
	@Id
	private String usuario;
	private String senha;
	@OneToOne(mappedBy = "login")
	private Funcionario funcionario;
	
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		this.funcionario.setLogin(this);
	}
	
	/**
	 * Converte o objeto Java para um objeto JSON
	 * @return Objeto JSON
	 */
	public JsonObject toJson() {
		return Json.createObjectBuilder()
				.add("usuario", this.usuario)
				.add("senha", this.senha)
				.build();
	}
	
	
	/**
	 * Converte uma string JSON em um objeto Java 
	 * @param json
	 * @return Objeto Java
	 */
	public Login toObject(String json) {
		JsonReader reader = Json.createReader(new StringReader(json));
		JsonObject jsonObject = reader.readObject();
		setSenha(jsonObject.getString("senha"));
		setUsuario(jsonObject.getString("usuario"));
		return this;
	}
	
}
