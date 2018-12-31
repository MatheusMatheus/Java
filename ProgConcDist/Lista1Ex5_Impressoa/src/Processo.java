import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Processo extends Thread {
	public static final int TIPOA = 1;
	public static final int TIPOB = 2;
	public static final int TIPOAB = 0;
	private int tipo;
	private List<Impressora> impressoras;

	public Processo(String nome, int tipo) {
		super(nome);
		this.tipo = tipo;
		this.impressoras = new ArrayList<Impressora>();
	}

	public void run() {
		while (true) {
			this.imprimir(new Documento((new Random()).nextInt(2000)));
			try {
				Thread.sleep((new Random()).nextInt(10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void adicionarImpressora(Impressora impressora) {
		this.impressoras.add(impressora);
	}
	
	public void imprimir(Documento documento) {
		int i, menor=0;
		boolean imprimiu=false;
		System.out.println(this.getName() +"("+ Principal.tipo(this.tipo) +") quer imprimir o documento["+ documento.getTamanho() +"]...");
		for (i=0; ((i<this.impressoras.size()) && (!imprimiu)); i++) {
			Impressora impressora=this.impressoras.get(i);
			if (impressora.isLivre()) {
				System.out.println(this.getName() +"("+ Principal.tipo(this.tipo) +") ira imprimir na "+ impressora.getNome() +"(LIVRE) o documento["+ documento.getTamanho() +"]...");
				impressora.imprimir(documento);
				imprimiu=true;
			} else {
				if (impressora.getTamanho() < this.impressoras.get(menor).getTamanho())
					menor=i;
			}
		}
		if (!imprimiu) {
			System.out.println(this.getName() +"("+ Principal.tipo(this.tipo) +") ira imprimir na "+ this.impressoras.get(menor).getNome() +"(FILA) o documento["+ documento.getTamanho() +"]");
			this.impressoras.get(menor).imprimir(documento);
		}
	}

}