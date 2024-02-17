<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>						
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Perfil - Atualizar dados</title>
        <link rel="stylesheet" href="./styles/configs.css">
		<link rel="stylesheet" href="./styles/atualizardados.css">
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
		<form action="atualizarUsuario">
            <h2>Atualizar Dados</h2>
            <div class="input-container">
                <label>Nome</label>
                <input type="text" placeholder="<%= usuarioOnline.getNome() %>" name="nome" value="<%= usuarioOnline.getNome() %>" required/>
            </div>
            <div class="input-container">
                <label>Email</label>
                <input type="email" placeholder="<%= usuarioOnline.getEmail() %>" name="email" value="<%= usuarioOnline.getEmail() %>" required/>
            </div>
            <div class="input-container">
                <label>Senha</label>
                <input type="password" placeholder="<%= usuarioOnline.getSenha() %>" name="senha" value="<%= usuarioOnline.getSenha() %>" required/>
            </div>
            <button type="submit">Atualizar</button>
        </form>
	</div>
	<%} //fechamento do else %>
	</body>
</html>