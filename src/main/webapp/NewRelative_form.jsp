<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
			size="20" required placeholder="Nombre" 
			<c:if test = "${not empty relative}"> value="${relative.relativename}"</c:if> /></p><br>
		<p><input type="text" name="lastname" id="lastname" maxLength="255"
			size="20" required placeholder="Apellidos" 
			<c:if test = "${not empty relative}"> value="${relative.lastname}"</c:if> /></p><br>
		<p><input type="text" name="mobilephone" id="mobilephone" maxLength="255"
			size="20" required placeholder="nº móvil" 
			<c:if test = "${not empty relative}"> value="${relative.mobilephone}"</c:if> /></p><br>
		<p><input type="text" name="landlinephone" id="landlinephone"
			maxLength="255" required size="20" placeholder="Teléfono Fijo" 
			<c:if test = "${not empty relative}"> value="${relative.landlinephone}"</c:if> /></p><br>
		<p><input type="text" name="address" id="adress"
			maxLength="255" required size="20" placeholder="Dirección" 
			<c:if test = "${not empty relative}"> value="${relative.address}"</c:if> /></p><br>
		<p><input type="text" name="location" id="location"
			maxLength="255" required size="20" placeholder="Localidad" 
			<c:if test = "${not empty relative}"> value="${relative.location}"</c:if> /></p><br>
		<p><input type="text" name="province" id="province"
			maxLength="255" required size="20" placeholder="Provincia" 
			<c:if test = "${not empty relative}"> value="${relative.province}"</c:if> /></p><br>
		<p><input type="submit" value="Send" /></p><br>
	</form>
	<a href="/verPaciente?email=${email}"> 
   <button type="button">Volver</button>
</a>
</body>

</html>