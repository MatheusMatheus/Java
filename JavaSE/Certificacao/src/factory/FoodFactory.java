package factory;

public class FoodFactory {
	public static Animal getComida(String nomeAnimal) {
		nomeAnimal = formataString(nomeAnimal);
		nomeAnimal = "factory." + nomeAnimal;
		try {
			Class classe = Class.forName(nomeAnimal);
			return (Animal) classe.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Good practice to throw an exception if no matching subclass could be
		// found
		throw new UnsupportedOperationException("Unsupported animal: " + nomeAnimal);
	}

	private static String formataString(String str) {
		str = str.toLowerCase();
		Character velho = str.charAt(0);
		Character novo = Character.toUpperCase(velho);
		return str.replaceFirst(velho.toString(), novo.toString());
	}

	public static void main(String[] args) {
		Animal a = FoodFactory.getComida("Cavalo");
		a.correr();
	}
}

abstract class Animal {
	private int idade;
	private String nome;

	public abstract void correr();

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

class Cachorro extends Animal {

	@Override
	public void correr() {
		System.out.println("O cachorro está correndo!");

	}

}

class Cavalo extends Animal {

	@Override
	public void correr() {
		System.out.println("O Cavalo está correndo!");

	}

}
