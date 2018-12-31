public class Gaiola {
	private int qtdPombos;
	
	public void entrar() {
		this.qtdPombos++;
	}
	
	public void libertar() {
		this.qtdPombos=0;
	}
	
	public int getQtdPombos() {
		return this.qtdPombos;
	}
	
}