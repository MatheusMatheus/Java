
package farmacia.view;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import farmacia.util.Leitor;

public class JOption implements Leitor {
	

	@Override
	public String lerString() {
		return null;
	}

	@Override
	public String lerString(String titulo, String msgErro) {
		try {
			return JOptionPane.showInputDialog(titulo);
		} catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(null, msgErro);
			return lerString(titulo, msgErro);
		}
	}

	@Override
	public int lerInt() {
		return 0;
	}

	@Override
	public int lerInt(String titulo, String msgErro) {
		try {
			return Integer.parseInt(JOptionPane.showInputDialog(titulo));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, msgErro);
			return lerInt(titulo, msgErro);
		}
	}

	@Override
	public int lerInt(String titulo, String msgErro, int min, int max) {
		int n = Integer.MIN_VALUE;
		do {
			n = lerInt(titulo, msgErro);
			if (n < min || n > max)
				JOptionPane.showMessageDialog(null, msgErro);
		} while (n < min || n > max);
		return n;
	}

	@Override
	public void mostrarMensagem(String msg) {
		JOptionPane.showMessageDialog(null, msg);

	}

}
