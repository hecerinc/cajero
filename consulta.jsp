<% 	
boolean isPost = (Boolean)request.getAttribute("isPost"); 
boolean exists = false;
if(isPost)
	exists = (Boolean)request.getAttribute("exists");

%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Banco AMSS</title>
<style>
	.container{
		width: 60%; 
		margin: 0 auto;
		margin-top:5%;
	}
	body{
		/*font-family: 'Open Sans', sans-serif;*/
	}
	.btn-menu{
		margin-top: 40px;
		display: block;
		width: 180px;
	}
</style>
</head>
<body>
	<div class="container">
		<h2>Cajero Electr&oacute;nico</h2>
		<h3>Consultar saldo</h3>
		<form action="Consulta" method="post">
			<label for="cuenta"># de cuenta:</label>
			<input type="text" name="cuenta" id="cuenta">	
			<input type="submit" value="Enviar">
		</form>
		<% if(isPost && !exists){ %>
			<p>La cuenta no existe, intente otra vez.</p>
		<% } 
			else if(isPost && exists){ %>
			<p style="margin-top: 30px;"><strong>Cuenta: </strong> <%= request.getAttribute("cuenta").toString() %></p>
			<p><strong>Saldo:</strong> $<%= request.getAttribute("saldo").toString() %></p>
		<% } %>
		<a href="menu.html" class="btn-menu">Regresar al men&uacute; principal</a>
	</div>
</body>
</html>
