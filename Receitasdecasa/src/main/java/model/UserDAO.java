package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DAO {
	private User usuario;

	public void cadastrarUsuario(User usuario) {
		String create = "insert into Usuarios (nome,email,senha,isAdmin) values (?,?,?,?)"; // comando a ser executado
																							// no bd

		try {
			Connection con = conectar(); // abrindo conexao

			PreparedStatement pst = con.prepareStatement(create); // preparando a query a ser executada

			// atribuindo os valores na query
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.setBoolean(4, false);

			pst.executeUpdate(); // executando comandos

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public User validarCredenciais(String email, String senha) {
		usuario = null;
		String query = "SELECT * FROM Usuarios WHERE email = ? AND senha = ?"; // comando a ser
																				// executado no bd

		try {
			Connection con = conectar(); // abrindo conexao

			PreparedStatement pst = con.prepareStatement(query); // preparando a query a ser executada

			// atribuindo os valores na query
			pst.setString(1, email);
			pst.setString(2, senha);
			System.out.println(email);
			System.out.println(senha);
			ResultSet resultSet = pst.executeQuery(); // executando comandos

			if (resultSet.next()) { // Encontrou um resultado
				// pega os dados desse resultado
				int usuarioId = resultSet.getInt("usuario_id");
				String nome = resultSet.getString("nome");
				int qntReceitas = resultSet.getInt("qntReceitas");
				boolean isAdmin = resultSet.getBoolean("isAdmin");

				usuario = new User(usuarioId, nome, email, senha, qntReceitas, isAdmin); // preenche um novo user para retornar
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return usuario;
	}

	public boolean deletarUsuario(int id) {
		String delete = "DELETE FROM Usuarios WHERE usuario_id = ?";// comando a ser executado no bd

		try {
			Connection con = conectar(); // abrindo conexao

			PreparedStatement pst = con.prepareStatement(delete); // preparando a query a ser executada

			// atribuindo os valores na query
			pst.setInt(1, id);
			pst.executeUpdate(); // executando comandos (deletando o registro)

			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void atualizarUsuario(User usuario) {
		String update = "UPDATE Usuarios SET nome = ?, email = ?, senha = ? WHERE usuario_id = ?"; // comando a ser
																									// executado no bd

		try {
			Connection con = conectar(); // comando a ser executado no bd

			PreparedStatement pst = con.prepareStatement(update); // preparando a query a ser executada

			// atribuindo os valores na query
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.setInt(4, usuario.getId());

			pst.executeUpdate(); // executando comandos

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}