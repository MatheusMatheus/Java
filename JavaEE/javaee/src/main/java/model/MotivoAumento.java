package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MotivoAumento {
	PROMOCAO("Promoção"), ACORDO_COLETIVO("Acordo coletivo");
	
	private String motivo;
	
	
	
	
}
