<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastrar usuário</title>
    <link rel="stylesheet" href="./styles/cadastro.css">
    <link rel="stylesheet" href="./styles/configs.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link class="favicon" rel="shortcut icon" type="png" href="./imgs/favicon.png">
</head>
<body>
    <%@ include file="header.jsp" %>
    
    <% String alerta = (String)request.getAttribute("alerta"); 
	if (alerta != null) { %>
    	<p style="color: red; font-size: 16px "><%= alerta %></p>
    <% } %>
    <h2>Cadastro</h2>
    <form action="cadastroUsuario">
      	<div class="input-container">
    		<label>Nome</label>
        	<input type="text" placeholder="Informe o nome" name="nome" required/>
      	</div>
  
		<div class="input-container">
			<label>Email</label>
			<input type="email" placeholder="Informe o email" name="email" required/>
		</div>
  
		<div class="input-container">
			<label>Senha</label>
			<input type="password" placeholder="Informe a senha" name="senha" required/>
		</div>

		<div class="input-container">
			<label>Confirmação da Senha</label>
			<input type="password" placeholder="Informe a senha novamente" name="confsenha" required/>
		</div>	
		<div class="button">
			<button id="salvar" type="submit">Salvar</button>
		</div>
    </form>
</body>
</html>