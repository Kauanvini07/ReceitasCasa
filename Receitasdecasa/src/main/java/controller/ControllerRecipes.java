package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Recipe;
import model.RecipeDAO;

@WebServlet(urlPatterns = { "/index.html", "/receita" })
public class ControllerRecipes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecipeDAO dao = new RecipeDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		// Controle das requisições ao acessar as rotas desse servlet
		if (action.equals("/index.html")) {
			listarReceitas(request, response);
		} else if (action.equals("/receita")) {
			visualizarReceita(request, response);
		}
	}

	protected void listarReceitas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Recipe> receitas = dao.listarReceitas(); // pegar a lista de receitas no banco de dados

		// redirecionar para a pagina inicial mandando a lista de receitas a ser mostradas no jsp
		request.setAttribute("receitas", receitas);
		RequestDispatcher rd = request.getRequestDispatcher("/receitas.jsp");
		rd.forward(request, response);
	}

	protected void visualizarReceita(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    // Obtendo o parâmetro "IDreceitas" da requisição
	    int IDreceita = Integer.parseInt(request.getParameter("receita_id"));
	    
	    // Obtendo a receita com base no ID
	    Recipe receita = dao.getReceitaPorId(IDreceita);
	            
	    // Enviando a receita para o JSP
	    request.setAttribute("receita", receita);
	    RequestDispatcher rd = request.getRequestDispatcher("/receita.jsp");
	    rd.forward(request, response);
	}
	
	protected void VisualizarReceitasNaCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtendo o ID da categoria da solicitação
		try {
	        int idCategoria = Integer.parseInt(request.getParameter("categoria_id"));
	
	        ArrayList<Recipe> receitas = dao.getReceitasPorCategoria(idCategoria);
	
	        // Definindo as receitas como atributo da solicitação para enviar ao JSP
	        request.setAttribute("receitas", receitas);
	
	        // Encaminhando para o JSP para exibir as receitas
	        RequestDispatcher rd = request.getRequestDispatcher("/receitas.jsp");
	        rd.forward(request, response);
		} catch (NumberFormatException e) {

            response.sendRedirect("erro.jsp");
        }
	}
}
