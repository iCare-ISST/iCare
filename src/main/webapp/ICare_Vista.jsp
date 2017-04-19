<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ICare Vista principal</title>
</head>
<body>
<c:if test = "${not empty user}">
hola <c:out value = "${user}" />
<p> You can press the next link to <c:out value="${urlLinktext}" />
<a href=" <c:url value = "${url}" /> "> <c:out value = "${urlLinktext}" /></a></p>
</c:if>
</body>
</html>