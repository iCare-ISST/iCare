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
<h1> Formulario de inscripcion</h1>
<p>Por favor rellene sus datos para darse de alta como usuario:</p><br>
	<form action="/nuevoPaciente" method="post" acceptcharset="utf-8">
		<p><input hidden name="email" value="${user}" /></p><br>
		<p><input type="text" name="patientname" id="patientname" maxLength="255"
			size="20" required placeholder="Nombre" /></p><br>
		<p><input type="text" name="lastname" id="lastname" maxLength="255"
			size="20" required placeholder="Apellidos" /></p><br>
		<p><input type="text" name="birthdate" id="birthdate" maxLength="255"
			size="20" required placeholder="Fecha de nacimiento" /></p><br>
		<p><input type="text" name="mobilephone" id="mobilephone"
			maxLength="255" required size="20" placeholder="Móvil" /></p><br>
		<p><input type="text" name="landlinephone" id="landlinephone"
			maxLength="255" required size="20" placeholder="Teléfono fijo" /></p><br>
		<p><input type="text" name="address" id="address"
			maxLength="255" required size="20" placeholder="Dirección" /></p><br>
		<p><input type="text" name="location" id="location"
			maxLength="255" required size="20" placeholder="Localidad" /></p><br>
		<p><input type="text" name="province" id="province"
			maxLength="255" required size="20" placeholder="Provincia" /></p><br>
		<p><input type="submit" value="Send" /></p><br>
	</form>
</body>

<footer>

<br>
<b>Fecha</b> (
<script type="text/javascript">
var f = new Date();
document.write(f.getDate());
document.write("/");
document.write(f.getMonth() + 1);
document.write("/");
document.write(f.getFullYear());
</script>) <br>
<b>Hora</b> (
<script type="text/javascript">
var d = new Date();
document.write(d.getHours());
document.write(":");
document.write(d.getMinutes());
</script>)
</footer>
</html>