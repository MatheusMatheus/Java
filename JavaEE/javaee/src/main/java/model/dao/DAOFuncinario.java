package model.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.Funcionario;
import model.HistoricoSalarial;
import model.Login;
import model.Salario;

@qualifiers.Funcionario
public class DAOFuncinario implements DAO<Funcionario> {
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	private List<Funcionario> populaFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Funcionario funcionario = getFuncionario();
			funcionario.setSubordinados(populaSubordinados());
			getLogin(funcionario);
			funcionarios.add(funcionario);
		}
		return funcionarios;
	}
	
	private List<Funcionario> populaSubordinados() {
		List<Funcionario> funcs = new ArrayList<>();
		this.funcionarios.forEach(f -> funcs.add(getFuncionario()));
		return funcs;
	}
	
	private static HistoricoSalarial getHistorico() {
		HistoricoSalarial historico = new HistoricoSalarial();
		historico.setHistorico(Arrays.asList(getSalario(), getSalario(), getSalario(), getSalario()));
		return historico;
	}
	
	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}
	
	private static Funcionario getFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Funcionario " + new Random().nextInt(500));
		funcionario.setIdade(new Random().nextInt(100));
		funcionario.setMatricula(String.valueOf(new Random().nextInt(56565)));
		funcionario.setNivel(new Random().nextInt(5));
		funcionario.setHistoricoSalarial(getHistorico());
		return funcionario;
	}
	
	private static Salario getSalario() {
		Salario salario = new Salario();
		salario.setCargo("Implementador");
		salario.setData(LocalDate.of(2012, Month.APRIL, 15));
		salario.setSalario(BigDecimal.valueOf(5000));
		return salario;
	}
	
	private static Login getLogin(Funcionario funcionario) {
		Login login = new Login();
		login.setFuncionario(funcionario);
		login.setSenha("65165");
		login.setUsuario("jlkjlkjljl");
		return login;
	}

	@Override
	public Funcionario findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario findByField(String fieldName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Funcionario entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Funcionario save(Funcionario entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> getAll() {
		return populaFuncionarios();
	}
	
}