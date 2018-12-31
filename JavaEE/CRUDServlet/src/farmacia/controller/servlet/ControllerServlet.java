package farmacia.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import farmacia.controller.logica.Logica;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "farmacia.controller.logica." + parametro;
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			
			// Recebe o String após a execução da lógica
			String pagina = logica.executa(request, response);

			// Faz o forward para a página JSP
			//request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
}
