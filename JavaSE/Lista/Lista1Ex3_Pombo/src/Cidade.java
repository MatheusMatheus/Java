import java.util.ArrayList;
import java.util.List;

public class Cidade {
	private List<Carta> caixaPostal;
	private Gaiola gaiola;

	public Cidade() {
		this.caixaPostal = new ArrayList<Carta>();
		this.gaiola = new Gaiola();
	}

	public void enviarCarta(Carta carta) {
		synchronized (this.caixaPostal) {
			this.caixaPostal.add(carta);
			if (this.caixaPostal.size() == Pombo.QTDCARTAS)
				this.caixaPostal.notifyAll();
		}
	}

	public void receberCarta(List<Carta> bolsaPombo) {
		bolsaPombo.clear();
	}

	public List<Carta> getCaixaPostal() {
		return caixaPostal;
	}

	public Gaiola getGaiola() {
		return gaiola;
	}

}
