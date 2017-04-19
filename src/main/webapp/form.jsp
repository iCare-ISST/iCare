<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario</title>
</head>
<body>
	<form action="/nuevoPaciente" method="post" acceptcharset="utf-8">
		<input hidden name="email" value="${user}" />
		<input type="text" name="patientname" id="patientname" maxLength="255"
			size="20" required placeholder="Nombre" />
		<input type="text" name="lastname" id="lastname" maxLength="255"
			size="20" required placeholder="Apellidos" />
		<input type="text" name="mobilephone" id="mobilephone"
			maxLength="255" required size="20" placeholder="Móvil" />
		<input type="text" name="address" id="address"
			maxLength="255" required size="20" placeholder="Dirección" />
		<input type="submit" value="Send" />
	</form>

</body>
</html>