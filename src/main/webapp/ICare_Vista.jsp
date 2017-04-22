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
	<p>Bienvenido <c:out value = "${user}" /></p>
		<c:if test = "${not empty patients}">
				<div id="patientList">
					<h2> Pacientes </h2>
					<form action="/verPaciente" method="post" acceptcharset="utf-8">
						<table>
  							<thead>
    							<tr>
	      							<th>Nombre</th>
	      							<th>Apellidos</th>
	      							<th>Acción</th>
    							</tr>
  							</thead>
 							<tbody>
								<c:forEach items = "${patients}" var = "patienti">		
									<tr>		
										<td><c:out value = "${patienti.patientname}" /></td>
										<td><c:out value = "${patienti.lastname}" /> </td>
										<input hidden name="email" value="${patienti.email}" />
										<td><input type="submit" value="Ver" /></td>	
									</tr>
								</c:forEach>
								</tr>
					  		</tbody>
						</table>
					</form>
				</div>
		</c:if>	
		<footer>
			<nav> 
				<a href="/nuevoPaciente" > 
					<button type="button">Añadir Paciente</button>
				</a> 
			</nav>
		</footer>
	
		
<br>
<br>
<br>
<p> Desconexión
<a href=" <c:url value = "${url}" /> "> <c:out value = "${urlLinktext}" /></a></p>
</c:if>
</body>
</html>