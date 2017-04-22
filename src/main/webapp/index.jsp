<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>Login</title>
</head>
<body>
<h1> Bienvenido a Icare </h1>
<p> Identifíquese para usar icare </p>
<c:if test = "${empty user}">
<p> Autentíquese en el siguiente enlace: 
<a href=" <c:url value = "${url}" /> "> <c:out value = "${urlLinktext}" /></a></p>
</c:if>
<c:if test = "${not empty user}">
<p> Su usuario no tiene permiso para usar iCare, por favor autentíquese con una cuenta válida o
pongase en contacto con el administrador del sistema: 
<a href=" <c:url value = "${url}" /> "> <c:out value = "${urlLinktext}" /></a></p>
</c:if>
</body>
</html>