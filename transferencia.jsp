<% 
boolean isPost = (Boolean)request.getAttribute("isPost");
boolean error = false;
if(isPost)
	error = (Boolean)request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Banco AMSS</title>
<style>
	form > div{
		margin-bottom: 10px;
	}
	.submit{
		margin-bottom: 40px;
		margin-top: 20px;
	}
	.container{
		width: 60%;
		margin: 0 auto;
		margin-top: 5%;
	}
</style>
</head>
<body>
	<div class="container">
		<h1>Cajero Electr&oacute;nico</h1>
		<h2>Transferencia de Saldo</h2>
		<% if(isPost && error){ %>
			<p>Su operaci&oacute;n no puede ser realizada como la especific&oacute;, por favor, intente otra vez.</p>
		<% } %>
		<% if(!isPost || isPost && error){ %>
		<form action="Transferencia" method="post">
			<div>
				<label for="origen">Cuenta origen:</label><br>
				<input type="text" name="origen" id="origen">
			</div>
			<div>
				<label for="destino">Cuenta destino:</label><br>
				<input type="text" name="destino" id="destino">
			</div>
			<div>
				<label for="monto">Monto:</label><br>
				<input type="text" name="monto" id="monto">
			</div>
			<input type="submit" value="Enviar" class="submit">
		</form>
		<a href="menu.html">Regresar al men&uacute; principal</a>
		<% }
		else if(isPost && !error){
		%>
		<p>Su operaci&oacute;n ha sido realizada exitosamente. Gracias por su preferencia.</p>
		<button onclick="location.href='/cajero';">Terminar</button>
		<% } %>
	</div>
</body>
</html>
