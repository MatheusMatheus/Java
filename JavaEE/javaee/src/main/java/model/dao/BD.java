package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class BD {
	private static List<Funcionario> funcionarios;
	
	
	public static List<Funcionario> getLista() {
		return (funcionarios == null) ? new ArrayList<>() : funcionarios;
	}
}
