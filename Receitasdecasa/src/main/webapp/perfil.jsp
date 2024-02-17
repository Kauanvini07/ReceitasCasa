<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
	<head>						
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Perfil</title>
		<link rel="stylesheet" href="./styles/configs.css">
		<link rel="stylesheet" href="./styles/perfil.css">
		<link class="favicon" rel="shortcut icon" type="png" href="./imgs/favicon.png">
	</head>

	<body>
	<%@ include file="header.jsp" %>
	<% 
		if(usuarioOnline == null){
			response.sendRedirect("login.jsp");
		}else{
	%>
	<div class="container">
		<div class="perfil">
			<div class="perfilbox">
				<img src="./imgs/perfil_icon.svg" alt="ICON" class="perfil-circle">
				<div class="detalhes">
					<h2 class="nome-usuario"><%= usuarioOnline.getNome() %></h2>
					<p>Endereço de e-mail: <%= usuarioOnline.getEmail() %></p>
					<% if(usuarioOnline.getAdmin()){ %>
					<p>Descrição: Um usuario admnistrador</p>
					<%} else  {%>
					<p>Descrição: Um usuario qualquer</p>
					<%} %>
				</div>
			</div>
			<nav>
				<ul class="editar">
					<li>
						<a href="atualizardados.jsp" class="editarBtn">Editar</a>
					</li>
					<li>
						<a href="deleteUsuario" class="deletarBtn">Deletar</a>
					</li>
					<% if(usuarioOnline.getAdmin()){ %>
					<li>
						<a href="novareceita.jsp" class="cadastrarBtn">Nova Receita</a>
					</li>
					<%} %>
				</ul>
			</nav>
			<% if(usuarioOnline.getAdmin()){ %>
			<div class="quadro">
				<h3 class="titulo-quadro">Receitas Criadas</h3>
				<p class="numero-quadro"><%= usuarioOnline.getQntReceitas() %></p>
			</div>

			<div class="quadro">
				<h3 class="titulo-quadro">Curtidas Recebidas</h3>
				<p class="numero-quadro">50</p>
			</div>
			<%}else{ %>
			<hr>
			<br>
			<%} %>

			<nav class="sair">
				<a href="deslogar" id="sairBtn">Sair da Conta</a>
			</nav>
		</div>
		
	</div>
	<%} //fechamento de else%>
	</body>
</html>