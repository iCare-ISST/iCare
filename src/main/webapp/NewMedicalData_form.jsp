<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>Formulario</title>
</head>
<body>
<h1> Formulario de Datos Médicos</h1>
<p>Por favor rellene los datos médicos del paciente</p><br>
	<form action="/nuevosdatosmedicos" method="post" acceptcharset="utf-8">
		<p><input hidden name="email" value="${email}" /></p><br>
		<p><input type="text" name="alergias" id="alergias" maxLength="255"
			size="20" required placeholder="Alergias" /></p><br>
		<p><input type="text" name="cardiopatias" id="cardiopatias" maxLength="255"
			size="20" required placeholder="Cardiopatias" /></p><br>
		<p><input type="text" name="cardiovasculares" id="cardiovasculares" maxLength="255"
			size="20" required placeholder="Problemas Cardiovasculares" /></p><br>
		<p><input type="text" name="mentales" id="mentales"
			maxLength="255" required size="20" placeholder="Problemas Mentales" /></p><br>
		<p><input type="text" name="gruposanguineo" id="gruposanguineo"
			maxLength="255" required size="20" placeholder="Grupo Sanguineo" /></p><br>
		<p><input type="text" name="medicacion" id="medicacion"
			maxLength="255" required size="20" placeholder="Medicación" /></p><br>
		<p><input type="text" name="invalidez" id="invalidez"
			maxLength="255" required size="20" placeholder="Invalidez" /></p><br>
		<p><input type="text" name="sobrepeso" id="sobrepeso"
			maxLength="255" required size="20" placeholder="Problemas de Sobrepeso" /></p><br>
		<p><input type="text" name="otrasafecciones" id="otrasafecciones"
			maxLength="255" required size="20" placeholder="Otras Afecciones" /></p><br>
		<p><input type="submit" value="Send" /></p><br>
	</form>
</body>

</html>