package farmacia.teste;

import farmacia.util.Leitor;
import farmacia.util.Util;
import farmacia.view.JOption;
import farmacia.view.OpcoesMenu;

public class Principal {

	public static void main(String[] args) {
		Leitor modoLeitura = new JOption();

		OpcoesMenu opcao;

/*		do {
			opcao = Util.menu(modoLeitura);
			switch (opcao) {
			case INSERIR:
				Farmacia f;
				boolean insercaoValida;
				do {
					f = util.getFarmacia();
					insercaoValida = dto.valida(f);
					if (!insercaoValida)
						modoLeitura.mostrarMensagem("CNPJ já inserido");
				} while (!insercaoValida);
				dto.inserir(f);
				modoLeitura.mostrarMensagem("Inserido com sucesso");
				break;

			case 2:
				boolean alteracaoValida;
				do {
					dto = new FarmaciaDTO(util);
					alteracaoValida = dto.alterar();
					if (!alteracaoValida)
						modoLeitura.mostrarMensagem("Erro ao alterar");
				} while (!alteracaoValida);
				modoLeitura.mostrarMensagem("Farmácia alterada com sucesso");
				break;

			case 3:
				Collection<Farmacia> farmacias = dto.listar();
				if (farmacias.isEmpty())
					modoLeitura.mostrarMensagem("Não há farmácias cadastradas");
				util.listador(farmacias);
				break;

			case 4:
				if (farmacias.size() == 0)
					System.out.println("Nao ha farmacias cadastradas");
				else {
					id = util.listaBasica(farmacias, modoLeitura);
					dto.excluir(id);
				}
				break;

			default:
				break;
			}
		} while (opcao != OpcoesMenu.SAIR);*/
	}

}
