<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/main.css" />
	<title>Nuevo Aviso</title>
</head>

<body>
	<h1> Formulario de Aviso</h1>
	<p>Por favor rellene con los datos del aviso</p><br>
	<form action="/crearAviso" method="post" acceptcharset="utf-8">
		<p><input hidden name="patientemail" value="${patientEmail}" /></p>
		<p><label>Criticidad:    </label><select name="criticidad" id="criticidad" >
			<option>Alta</option>
			<option>Media</option>
			<option>Baja</option>
		</select></p>
		<p><input type="text" name="description" id="description" maxLength="255"
			size="20" required placeholder="Descripción"  /></p><br>
		<p><input type="submit" value="Send" /></p><br>
	</form>
</body>

</html>