package model;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;

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
	
	public List<Salario> toObject(String json) {
		JsonReader reader = Json.createReader(new StringReader(json));
		JsonObject object = reader.readObject();
		
		JsonArray salariosJson = object.getJsonArray("historico");
		salariosJson.stream()
				    .map(e -> Salario.toObject(e.toString()))
				    .forEach(historico::add);
		return historico;
	}
	
	
}
