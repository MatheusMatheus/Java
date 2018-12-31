package farmacia.util;

import farmacia.view.OpcoesMenu;

public class Util {
	public static OpcoesMenu menu(Leitor leitor) {
		int op = leitor.lerInt(conteudoMenu(), "Valor invalido", 1, 5);
		for (OpcoesMenu menu : OpcoesMenu.values()) 
			if(op == menu.getOpcao())
				return menu;
		return OpcoesMenu.SAIR;
	}

	private static String conteudoMenu() {
		StringBuilder sb = new StringBuilder();
		int item = 0;
		for (OpcoesMenu menu : OpcoesMenu.values()) {
			item = menu.getOpcao();
			sb.append("\n" + item);
			sb.append(" - ");
			sb.append(menu.name());
		}
		return sb.toString();
	}
}
