package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonObject;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("usuario" + " : " + this.usuario)
			   .append("senha" + " : " + this.senha);
		return builder.toString();
	}
	
	public JsonObject toJson() {
		return Json.createObjectBuilder()
				.add("usuario", this.usuario)
				.add("senha", this.senha)
				.build();
	}
}
