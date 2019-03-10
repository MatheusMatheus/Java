package model;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoricoSalarial {
	@OneToMany
	private List<Salario> historico;

	public HistoricoSalarial() {
		this.historico = new ArrayList<>();
	}

	public JsonArray toJson() {
		JsonArrayBuilder list = Json.createArrayBuilder();
		historico.stream()
				 .map(e -> e.toJson())
				 .forEach(list::add);
		return list.build();
	}
	
	public HistoricoSalarial toObject(JsonArray jsonArray) {
		jsonArray.stream()
				 .map(e -> Salario.toObject(e.asJsonObject()))
				 .forEach(historico::add);
		return this;
	}
	
	
}
