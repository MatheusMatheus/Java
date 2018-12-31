package farmacia.teste;

import java.time.LocalDate;

import farmacia.model.Cidade;
import farmacia.model.Estado;
import farmacia.model.Laboratorio;
import farmacia.model.Medicamento;
import farmacia.model.TipoMedicamento;
import farmacia.model.dao.CidadeDAO;
import farmacia.model.dao.DAO;
import farmacia.model.dao.EstadoDAO;
import farmacia.model.dao.LaboratorioDAO;
import farmacia.model.dao.MedicamentoDAO;
import farmacia.util.CriaObjetos;

public class PopulaBanco {
	public static void main(String[] args) {

		Estado estado1 = CriaObjetos.newEstado(1, "Distrito Federal", "DF");
		Estado estado2 = CriaObjetos.newEstado(2, "Sao Paulo", "SP");
		Estado estado3 = CriaObjetos.newEstado(3, "Rio Grande do Sul", "RS");
		Estado estado4 = CriaObjetos.newEstado(4, "Bahia", "BA");
		Estado estado5 = CriaObjetos.newEstado(5, "Amazonas", "AM");

		DAO<Estado> daoEstado = new EstadoDAO();
		daoEstado.inserir(estado1);
		daoEstado.inserir(estado2);
		daoEstado.inserir(estado3);
		daoEstado.inserir(estado4);
		daoEstado.inserir(estado5);

		Cidade cidade1 = CriaObjetos.newCidade(1, "Brasilia", estado1);
		Cidade cidade2 = CriaObjetos.newCidade(2, "Sao Jose dos Campos", estado2);
		Cidade cidade3 = CriaObjetos.newCidade(3, "Gramado", estado3);
		Cidade cidade4 = CriaObjetos.newCidade(4, "Salvador", estado4);
		Cidade cidade5 = CriaObjetos.newCidade(5, "Manaus", estado5);

		DAO<Cidade> daoCidade = new CidadeDAO();
		daoCidade.inserir(cidade1);
		daoCidade.inserir(cidade2);
		daoCidade.inserir(cidade3);
		daoCidade.inserir(cidade4);
		daoCidade.inserir(cidade5);

		Laboratorio laboratorio1 = CriaObjetos.newLaboratorio(1, "NC FARMA", cidade1);
		Laboratorio laboratorio2 = CriaObjetos.newLaboratorio(2, "HYPERMARCAS", cidade2);
		Laboratorio laboratorio3 = CriaObjetos.newLaboratorio(3, "NOVARTIS", cidade3);
		Laboratorio laboratorio4 = CriaObjetos.newLaboratorio(4, "EUROFARMA", cidade4);
		Laboratorio laboratorio5 = CriaObjetos.newLaboratorio(5, "TAKEDA PHARMA", cidade5);

		DAO<Laboratorio> daoLab = new LaboratorioDAO();
		daoLab.inserir(laboratorio1);
		daoLab.inserir(laboratorio2);
		daoLab.inserir(laboratorio3);
		daoLab.inserir(laboratorio4);
		daoLab.inserir(laboratorio5);

		Medicamento medicamento1 = CriaObjetos.newMedicamento(1, "Imipramina", LocalDate.of(2018, 1, 20), laboratorio1,
				TipoMedicamento.ALPATICO);
		Medicamento medicamento2 = CriaObjetos.newMedicamento(2, "Fluoxetina", LocalDate.of(2019, 1, 17), laboratorio2,
				TipoMedicamento.FITOTERAPICO);
		Medicamento medicamento3 = CriaObjetos.newMedicamento(3, "Venlafaxina", LocalDate.of(2017, 2, 22), laboratorio3,
				TipoMedicamento.GENERICO);
		Medicamento medicamento4 = CriaObjetos.newMedicamento(4, "Mirtazapina", LocalDate.of(2021, 4, 13), laboratorio4,
				TipoMedicamento.HOMEOPATICO);
		Medicamento medicamento5 = CriaObjetos.newMedicamento(5, "Duloxetina", LocalDate.of(2010, 9, 10), laboratorio5,
				TipoMedicamento.MANIPULADO);

		DAO<Medicamento> daoMed = new MedicamentoDAO();
		daoMed.inserir(medicamento1);
		daoMed.inserir(medicamento2);
		daoMed.inserir(medicamento3);
		daoMed.inserir(medicamento4);
		daoMed.inserir(medicamento5);
	}
}
