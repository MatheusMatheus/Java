package br.com.teste.modelo;


public class Pessoa {

private String cpf;
private String nome;
private int idade;
private double salario;

public Pessoa(String cpf, String nome, int idade, double salario) {
	super();
	this.cpf = cpf;
	this.nome = nome;
	this.idade = idade;
	this.salario = salario;
}

public double getSalario() {
	return salario;
}

public void setSalario(double salario) {
	this.salario = salario;
}

public int getIdade() {
	return idade;
}

public void setIdade(int idade) {
	this.idade = idade;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}
}
