package model;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoricoSalarial {
	private List<Salario> historico;

	public HistoricoSalarial() {
		this.historico = new ArrayList<>();
	}

	public JsonArray toJson() {
		JsonArrayBuilder list = Json.createArrayBuilder();
		historico
			.stream()
			.map(e -> e.toJson())
			.forEach(list::add);
		return list.build();
	}
	
	
}
