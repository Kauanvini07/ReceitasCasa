<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nova Receita</title>
    <link rel="stylesheet" href="./styles/novareceita.css">
    <link rel="stylesheet" href="./styles/configs.css">
    <link class="favicon" rel="shortcut icon" type="png" href="./imgs/favicon.png">
</head>
<body>
    <%@ include file="header.jsp" %>
	<% 
		if(usuarioOnline == null || !usuarioOnline.getAdmin()){
			response.sendRedirect("login.jsp");
		}%>
	<%  String alerta = (String)request.getAttribute("alerta"); %>
	<%  if (alerta != null) { %>
    		<p style="color: red; font-size: 16px "><%= alerta %></p>
    <%  } %>
    <div class="container">
        <h2>Nova Receita</h2>
        <form action="cadastrarReceita">
            <div class="recipe">
            	<h3>Titulo</h3>
            	<input type="text" name = "titulo" required>
            	<h3>Ingredientes</h3>
            	<textarea name="ingredientes" required></textarea>
                <h3>Modo de preparo</h3>
                <textarea name="conteudo" required></textarea>
            </div>
            <div class="categorias">
                <h3>Categorias da receita</h3>
                <div class="categorias-inputs">
                    <div class="categorias-group">
                        <input type="checkbox" id="cafedamanha" name="categorias[]" value="Cafe da manha">
                        <label for="cafedamanha">Cafe da manha</label>
                    </div>
                    <div class="categorias-group">
                        <input type="checkbox" id="almoco" name="categorias[]" value="Almoco">
                        <label for="almoco">Almoco</label>
                    </div>
                    <div class="categorias-group">
                        <input type="checkbox" id="cafedatarde" name="categorias[]" value="Cafe da tarde">
                        <label for="cafedatarde">Cafe da tarde</label>
                    </div>
                    <div class="categorias-group">
                        <input type="checkbox" id="janta" name="categorias[]" value="Janta">
                        <label for="janta">Janta</label>
                    </div>
                    <div class="categorias-group">
                        <input type="checkbox" id="massas" name="categorias[]" value="Massas">
                        <label for="massas">Massas</label>
                    </div>
                    <div class="categorias-group">
                        <input type="checkbox" id="bebidas" name="categorias[]" value="Bebidas">
                        <label for="bebidas">Bebidas</label>
                    </div>
                </div>
            </div>
            <div class="button">
                <button type="submit">Criar</button>
            </div>
        </form>
    </div>
</body>
</html>