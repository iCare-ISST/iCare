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
<h1>iCare</h1>

<c:if test = "${not empty user}">
	<p>Bienvenido <c:out value = "${user}" /></p>
		<c:if test = "${not empty avisos}">
			<div id="avisosList">
				<h2>Avisos</h2>
				<table>
					<thead>
						<tr>
   							<th>Criticidad</th>
   							<th>Descripción</th>
   							<th>Paciente</th>
						</tr>
					</thead>
					
					<tbody>
					<c:forEach items = "${avisosAlta}" var = "avisoi">
						<tr>		
							<td><c:out value = "${avisoi.criticidad}" /></td>
							<td><c:out value = "${avisoi.description}" /></td>
							<td><c:out value = "${avisoi.patientEmail}" /></td>
						</tr>
					</c:forEach>
					<c:forEach items = "${avisosMedia}" var = "avisoi">
						<tr>		
							<td><c:out value = "${avisoi.criticidad}" /></td>
							<td><c:out value = "${avisoi.description}" /></td>
							<td><c:out value = "${avisoi.patientEmail}" /></td>
						</tr>
					</c:forEach>
					<c:forEach items = "${avisosBaja}" var = "avisoi">
						<tr>		
							<td><c:out value = "${avisoi.criticidad}" /></td>
							<td><c:out value = "${avisoi.description}" /></td>
							<td><c:out value = "${avisoi.patientEmail}" /></td>
						</tr>
					</c:forEach>
		  			</tbody>
				</table>
			</div>
		</c:if>
		<c:if test = "${not empty patients}">
				<div id="patientList">
					<h2> Pacientes </h2>
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
										<td><a href="/verPaciente?email=${patienti.email}"> 
              							<button type="button"> Ver </button>
           								</a></td>	
									</tr>
								</c:forEach>
					  		</tbody>
						</table>
				
				</div>
		</c:if>	
		<footer>
			<nav> 
				<a href="/nuevoPaciente?email=null" > 
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