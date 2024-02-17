package model;

//importar Connection e DrivevrManager do java (JDBC)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// Parâmetros para conexão
	private String driver = "com.mysql.cj.jdbc.Driver"; // driver na pasta WEB-INF/lib
	private String url = "jdbc:mysql://127.0.0.1/db_receitas?useTimeZone=true&serverTimeZone=UTC";
	private String user = "root";
	private String password = "07151129";

	// Conexão com o bd
	protected Connection conectar() {
		Connection con = null; // Connection de java.sql

		try {
			Class.forName(driver); // ler o driver para conexão
			con = DriverManager.getConnection(url, user, password); // Realizar a conexao com os parametros definidos
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	protected User getAuthorById(int autorid) {
		String query = "SELECT * FROM Usuarios WHERE usuario_id = ?";
		try {
			Connection con = conectar(); // Estabelece conexão com o banco de dados
			PreparedStatement pst = con.prepareStatement(query); // Prepara a declaração SQL
			pst.setInt(1, autorid); // Define o ID do autor na consulta SQL
			ResultSet rs = pst.executeQuery(); // Executa a consulta SQL e obtém o resultado
			if (rs.next()) { // Verifica se há um resultado
				// Extrai os dados do autor do resultado da consulta
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String senha = rs.getString(4);
				int qntReceitas = rs.getInt(5);
				boolean isAdmin = rs.getBoolean(6);
				con.close(); // Fecha a conexão com o banco de dados
				return new User(id, nome, email, senha, qntReceitas, isAdmin); // Retorna um objeto User com os dados do autor
			}
		} catch (Exception e) {
			System.out.println(e); // Trata qualquer exceção que possa ocorrer e imprime no console
		}
		return null; // Retorna null se não encontrar o autor com o ID especificado
	}

	public ArrayList<Category> getCategoriesById(int id) {
		ArrayList<Category> categories = new ArrayList<>(); // Cria uma lista para armazenar as categorias
		// Consulta SQL para obter as categorias associadas à receita com o ID
		// especificado
		String query = "SELECT c.categoria_id, c.nome FROM Categorias c JOIN ReceitasCategorias rc ON c.categoria_id = rc.categoria_id WHERE rc.receita_id = ?";
		try {
			Connection con = conectar(); // Estabelece conexão com o banco de dados
			PreparedStatement pst = con.prepareStatement(query); // Prepara a declaração SQL
			pst.setInt(1, id); // Define o ID da receita na consulta SQL
			ResultSet rs = pst.executeQuery(); // Executa a consulta SQL e obtém o resultado
			while (rs.next()) { // Itera sobre o resultado para extrair as categorias
				// Extrai os dados da categoria do resultado da consulta
				int categoryId = rs.getInt(1);// É importante ferificar se mantem o ID como String
				String categoryName = rs.getString(2);
				categories.add(new Category(categoryId, categoryName)); // Adiciona a categoria à lista de categorias
			}
			con.close(); // Fecha a conexão com o banco de dados
		} catch (Exception e) {
			System.out.println(e); // Trata qualquer exceção que possa ocorrer e imprime no console
		}
		return categories; // Retorna a lista de categorias associadas à receita
	}

}