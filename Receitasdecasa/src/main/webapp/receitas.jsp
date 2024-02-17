<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Recipe" %>
<%@ page import="java.util.ArrayList" %>
<%ArrayList<Recipe> receitas = (ArrayList<Recipe>) request.getAttribute("receitas");%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
	<title>Receitas de casa</title>
	<link rel="stylesheet" href="./styles/configs.css">
	<link rel="stylesheet" href="./styles/receitas.css">
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<div class="categorias">
        <h2>Categorias</h2>
          <div class="categoria-item">
            <img src="./imgs/imagem1.jpg">
            <p>Café da Manhã</p>
          </div>
          <div class="categoria-item">
            <img src="./imgs/imagem2.jpg">
            <p>Almoço</p>
          </div>
          <div class="categoria-item">
            <img src="./imgs/imagem3.jpg">
            <p>Café da tarde</p>
          </div>
          <div class="categoria-item">
            <img src="./imgs/imagem4.jpg">
            <p>Jantar</p>
          </div>
          <div class="categoria-item">
            <img src="./imgs/imagem5.jpg">
            <p>Doces e Sobremesas</p>
          </div>
          <div class="categoria-item">
            <img src="./imgs/imagem6.jpg">
            <p>Bebidas</p>
          </div>
      </div>

      <div class="receitasRecentes">
        <h2>Receitas Recentes</h2>
          <%for(int i=0;i < receitas.size() && i<12;i++){%>
          <div class="quadroReceita">
            <p class="usuarioPub"><%= receitas.get(i).getAutor().getNome() %></p>
            <a href="receita?id_receita=<%= receitas.get(i).getId() %>" class="tituloReceita"><%= receitas.get(i).getTitulo() %></a>
            <p class="qntComentarios">Quantidade de comentários: <%= receitas.get(i).getQntComentario() %></p>
            <p class="dataPub"><%= receitas.get(i).getData() %></p>
          </div>
          <%} %>
      </div>
</body>
</html>