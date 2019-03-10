package model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Salario {
	private LocalDate data;
	private BigDecimal salario;
	private String cargo;
	@Enumerated(EnumType.STRING)
	private MotivoAumento motivo;
	
	public JsonObject toJson() {
		return Json.createObjectBuilder()
				.add("salario", String.valueOf(salario))
				.add("cargo", this.cargo)
				.add("data", this.data.toString())
				.add("motivo", this.motivo.getMotivo())
				.build();
	}
	
	public static Salario toObject(JsonObject jsonObject) {
		Salario s = new Salario();
		s.setCargo(jsonObject.getString("cargo"));
		s.setSalario(new BigDecimal(jsonObject.getString("salario")));
		s.setData(LocalDate.parse(jsonObject.getString("data")));
		s.setMotivo(MotivoAumento.valueOf(jsonObject.getString("motivo")));
		return s;
	}
}
