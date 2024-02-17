<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="./styles/configs.css">
    <link rel="stylesheet" href="./styles/login.css">
	<link class="favicon" rel="shortcut icon" type="png" href="./imgs/favicon.png">
</head>
<body>
  	<%@ include file="header.jsp" %>
  	<% 
  		if(usuarioOnline != null){
			response.sendRedirect("perfil.jsp");
		}else{
  	%>
  	<%  String alerta = (String)request.getAttribute("alerta"); %>
	<%  if (alerta != null) { %>
    		<p style="color: red; font-size: 18px "><%= alerta %></p>
    <%  } %>
  
    <h2>Login</h2>

    <form id="form" action="login">
      	<div class="input-container">
        	<label>Email</label>
        	<input type="email" placeholder="Informe o email" name="email" required/>
      	</div>
  
      	<div class="input-container">
        	<label>Senha</label>
        	<input type="password" placeholder="Informe a senha" name="senha" required/>
      	</div>
      
 		<button id="entrar" type="submit">Entrar</button>

    	<h3>NÃ£o possui cadastro? <a href="cadastro.jsp">Cadastrar</a></h3>
    </form>

    <%} //fechamento do else %>
</body>
</html>