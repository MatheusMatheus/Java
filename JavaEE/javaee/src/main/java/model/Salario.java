package model;

import java.io.StringReader;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Salario {
	private LocalDate data;
	private BigDecimal salario;
	private String cargo;
	
	public JsonObject toJson() {
		return Json.createObjectBuilder()
				.add("salario", String.valueOf(salario))
				.add("cargo", cargo)
				.add("data", data.toString())
				.build();
	}
	
	public static Salario toObject(String json) {
		JsonReader reader = Json.createReader(new StringReader(json));
		JsonObject jsonObject = reader.readObject();
		
		Salario s = new Salario();
		s.setCargo(jsonObject.getString("cargo"));
		s.setSalario(new BigDecimal(jsonObject.getString("salario")));
		s.setData(LocalDate.parse(jsonObject.getString("data")));
		
		return s;
	}
	
}
