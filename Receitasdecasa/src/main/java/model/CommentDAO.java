package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;// tive que importar p/ usar array's
import java.sql.ResultSet;


public class CommentDAO extends DAO {

    // Método para adicionar um comentário ao banco de dados
    public void adicionarComentario(Comment comentario) {
        String query = "INSERT INTO Comentarios (texto, usuario_id, receita_id) VALUES (?, ?, ?)";
        try {
            Connection con = conectar(); // Estabelece a conexão com o banco de dados
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, comentario.getConteudo()); // Define o conteúdo do comentário
            pst.setInt(2, comentario.getAutor().getId()); // Define o ID do usuário que fez o comentário
            pst.setInt(3, comentario.getReceita().getId()); // Define o ID da receita associada ao comentário
            //Verificar se esse parâmetros estão corretos 
            pst.executeUpdate(); // Executa a inserção
            con.close(); // Fecha a conexão com o banco de dados
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar comentário: " + e.getMessage());
        }
    }

    public ArrayList<Comment> getComentariosPorReceita(int idReceita) {
        ArrayList<Comment> comentarios = new ArrayList<>();
        String query = "SELECT * FROM Comentarios WHERE receita_id = ?";
        try {
            Connection con = conectar(); // Estabelece a conexão com o banco de dados
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, idReceita); // Define o ID da receita como filtro
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("comentario_id");
                String texto = rs.getString("texto");
                int usuarioId = rs.getInt("usuario_id");
                User autor = getAuthorById(usuarioId); // Obter informações do autor do comentário
               
                String dataCriacao = rs.getString("data_criacao");
                // Construindo o objeto Comment com os dados obtidos do banco de dados
                Comment comentario = new Comment(id, texto, dataCriacao, autor, null);
                comentarios.add(comentario); // Adiciona o comentário à lista de comentários
            }
            con.close(); // Fecha a conexão com o banco de dados
        } catch (SQLException e) {
            System.out.println("Erro ao obter comentários da receita: " + e.getMessage());
        }
        
        return comentarios; // Retorna a lista de comentários
    }
    
}

/*
public ArrayList<Comment> getTodosComentarios() {
    ArrayList<Comment> comentarios = new ArrayList<>();
    String query = "SELECT * FROM Comentarios";
    try {
        Connection con = conectar(); // Estabelece a conexão com o banco de dados
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("comentario_id");
            String texto = rs.getString("texto");
            int usuarioId = rs.getInt("usuario_id");
            User autor = getAuthorById(usuarioId); // Obter informações do autor do comentário
            //int receitaId = rs.getInt("receita_id");
            // Você pode ajustar a obtenção de informações sobre a receita conforme necessário
            Recipe receita = new Recipe(); // Aqui você pode obter a receita associada ao comentário
            String dataCriacao = rs.getString("data_criacao");
            // Construa o objeto Comment com os dados obtidos do banco de dados
            Comment comentario = new Comment(id, texto, dataCriacao, autor, receita);
            comentarios.add(comentario); // Adiciona o comentário à lista de comentários
        }
        con.close(); // Fecha a conexão com o banco de dados
    } catch (SQLException e) {
        System.out.println("Erro ao obter todos os comentários: " + e.getMessage());
    }
    return comentarios; // Retorna a lista de comentários
}
*/
