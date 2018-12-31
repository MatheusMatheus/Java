package farmacia.util;

import java.time.LocalDate;
import java.util.Calendar;

import farmacia.model.Cidade;
import farmacia.model.Estado;
import farmacia.model.Laboratorio;
import farmacia.model.Medicamento;
import farmacia.model.TipoMedicamento;

public class CriaObjetos {
	public static Estado newEstado(int id, String nome, String uf) {
		Estado estado = new Estado();
		estado.setId(id);
		estado.setNome(nome);
		estado.setUF(uf);
		return estado;
	}
	
	public static Cidade newCidade(int id, String nome, Estado estado) {
		Cidade cidade = new Cidade();
		cidade.setEstado(estado);
		cidade.setId(id);
		cidade.setNome(nome);
		return cidade;
	}
	
	public static Laboratorio newLaboratorio(int id, String nome, Cidade cidade) {
		Laboratorio laboratorio = new Laboratorio();
		laboratorio.setId(id);
		laboratorio.setNome(nome);
		laboratorio.setCidade(cidade);
		return laboratorio;
	}
	
	public static Medicamento newMedicamento(int id, String nome, LocalDate validade, Laboratorio laboratorio, TipoMedicamento tipo) {
		Medicamento medicamento = new Medicamento();
		medicamento.setId(id);
		medicamento.setNome(nome);
		medicamento.setValidade(validade);
		medicamento.setLaboratorio(laboratorio);
		medicamento.setTipo(tipo);
		return medicamento;
	}
}
