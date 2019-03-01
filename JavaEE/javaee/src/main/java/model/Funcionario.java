package model;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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
	
	@OneToOne
	@JoinColumn(name = "login_fk")
	private Login login;
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Funcionario> subordinados;
	
	@Transient
	private int nivel;
	
	public Funcionario() {
		this.subordinados = new ArrayList<>();
	}
	
	public JsonObject toJson() {
		return Json.createObjectBuilder()
				.add("matricula", this.matricula)
				.add("nome", this.nome)
				.add("idade", this.idade)
				.add("nivel", this.nivel)
				.add("login", this.getLogin().toJson())
				.add("historico", this.historicoSalarial.toJson())
				.add("subordinados", toJsonArray())
				.build();
	}
	
	private JsonArray toJsonArray() {
		JsonArrayBuilder list = Json.createArrayBuilder();
		subordinados
			.stream()
			.map(e -> e.toJson())
			.forEach(list::add);
		return list.build();
	}
}
