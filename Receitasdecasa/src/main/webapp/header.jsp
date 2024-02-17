<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% User usuarioOnline = (User) session.getAttribute("usuario"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/configs.css">
    <link rel="stylesheet" href="./styles/header.css">
</head>
<body>
    <header class="header">
        <h1><a href="index.html">RECEITAS DE CASA</a></h1>
        <nav>
	        <ul class="menu">
	        	<% if(usuarioOnline == null){ %>
		            <a class="headerlink" href="login.jsp">Login</a>
		            <a class="headerlink" href="cadastro.jsp">Cadastro</a>
	            <% }else{ %>
	            	<a class="headerlink" href="perfil.jsp">Perfil</a>
	            <% } %>
	        </ul>
        </nav>
    </header>
</body>
</html>


