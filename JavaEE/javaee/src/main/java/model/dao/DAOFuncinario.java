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
	
	public DAOFuncinario() {
		//BD.funcionarios.addAll(populaFuncionarios());
	}
	
	private List<Funcionario> populaFuncionarios() {
		for(int i = 0; i < 10; i++) {
			Funcionario funcionario = getFuncionario();
			funcionario.setSuperior(getFuncionario());
			funcionario.setLogin(getLogin(funcionario));
			BD.getLista().add(funcionario);
		}
		return BD.getLista();
	}
	
	public List<Funcionario> populaSubordinados() {
		List<Funcionario> funcionarios = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Funcionario funcionario = getFuncionario();
			funcionario.setLogin(getLogin(funcionario));
			funcionarios.add(funcionario);
		}
		return funcionarios;
	}
	
	private static HistoricoSalarial getHistorico() {
		HistoricoSalarial historico = new HistoricoSalarial();
		historico.setHistorico(Arrays.asList(getSalario(), getSalario(), getSalario(), getSalario()));
		return historico;
	}
	
	private static Funcionario getFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Funcionario " + new Random().nextInt(500));
		funcionario.setIdade(new Random().nextInt(100));
		funcionario.setMatricula(String.valueOf(new Random().nextInt(56565)));
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
		login.setSenha(String.valueOf(new Random().nextInt(56565)));
		login.setUsuario("jlkjlkjljl");
		return login;
	}

	@Override
	public Funcionario findById(String id) {
		return BD.getLista().stream()
						   .filter(f -> f.getMatricula().equals(id))
						   .findFirst().orElse(getSubordinado(id));
	}
	
	private Funcionario getSubordinado(String matricula) {
		return BD.getLista().stream()
				   .filter(f -> f.getMatricula().equals(matricula))
				   .findFirst().orElse(null);
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
	public Funcionario save(Funcionario funcionario) {
		return BD.getLista().add(funcionario) ? funcionario : null;
	}

	@Override
	public List<Funcionario> getAll() {
		return BD.getLista();
	}
	
}
