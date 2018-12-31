package farmacia.controller.logica;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import farmacia.model.Medicamento;
import farmacia.model.dao.DAO;
import farmacia.model.dao.MedicamentoDAO;

public class ListaMedicamentosLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		DAO<Medicamento> dao = new MedicamentoDAO();
		Collection<Medicamento> medicamentos = dao.getLista();
		
		req.setAttribute("medicamentos", medicamentos);
		return "lista-medicamentos.jsp";
	}

}
