<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>ICare Vista principal</title>
</head>
<body>
<h1> iCare </h1>

<c:if test = "${not empty user}">
	<p>hola <c:out value = "${user}" /></p>
		<c:if test = "${not empty patients}">
			<p> Pacientes:</p>
			<br>
			<c:forEach items = "${patients}" var = "patienti">
					<form action="/verPaciente" method="post" acceptcharset="utf-8">
						<td><c:out value = "${patienti.patientname}" /></td>
						<td><input hidden name="email" value="${patienti.email}" /></td><br>
						<td><input type="submit" value="Ver" /></td><br>
					</form>
						
			</c:forEach>
		</c:if>
		<br>
		Incluir Nuevo Paciente
<br>
<br>
<br>
<p> Desconexión
<a href=" <c:url value = "${url}" /> "> <c:out value = "${urlLinktext}" /></a></p>
</c:if>
</body>
</html>