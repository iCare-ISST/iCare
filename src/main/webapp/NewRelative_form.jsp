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
<h1> Formulario de Cuidadores</h1>
<p>Por favor rellene con los datos del cuidador del paciente</p><br>
	<form action="/nuevocuidador" method="post" acceptcharset="utf-8">
		<p><input hidden name="patientemail" value="${email}" /></p><br>
		<p><input type="text" name="relativename" id="relativename" maxLength="255"
			size="20" required placeholder="Nombre" /></p><br>
		<p><input type="text" name="lastname" id="lastname" maxLength="255"
			size="20" required placeholder="Apellidos" /></p><br>
		<p><input type="text" name="mobilephone" id="mobilephone" maxLength="255"
			size="20" required placeholder="nº móvil" /></p><br>
		<p><input type="text" name="landlinephone" id="landlinephone"
			maxLength="255" required size="20" placeholder="Teléfono Fijo" /></p><br>
		<p><input type="text" name="dirección" id="dirección"
			maxLength="255" required size="20" placeholder="Dirección" /></p><br>
		<p><input type="text" name="location" id="location"
			maxLength="255" required size="20" placeholder="Localidad" /></p><br>
		<p><input type="text" name="province" id="province"
			maxLength="255" required size="20" placeholder="Provincia" /></p><br>
		<p><input type="submit" value="Send" /></p><br>
	</form>
</body>

</html>