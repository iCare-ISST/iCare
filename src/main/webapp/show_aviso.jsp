<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>Vista de Aviso</title>
</head>
<body>
<h2>Aviso</h2>
<p>El paciente: <c:out value="${patient.patientname}"></c:out> ha enviado un aviso de criticidad <c:out value="${aviso.criticidad}"></c:out></p>
<p>Descripción: <c:out value="${aviso.description}"></c:out> </p>
<h2>Acciones:</h2>
<ul style="list-style-type:disc" >
	<li>Enviar correo al cuidador</li>
	<li>Mostrar mapa de recursos sanitarios</li>
	<li>Mostrar mapa de recursos sociales</li>	
</ul>
</body>
</html>