package model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.json.Json;
import javax.json.JsonObject;

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
	
}
