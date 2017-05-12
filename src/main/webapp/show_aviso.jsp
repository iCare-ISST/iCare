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
<p><ul style="list-style-type:disc" >
	<li>Enviar correo al cuidador</li>
	<li>Mostrar mapa de recursos sanitarios</li>
	<li>Mostrar mapa de recursos sociales</li>	
</ul></p>

<div id="contenedor">
    <input id="tab-1" type="radio" name="radio-set" class="tab-selector-1" checked="checked" />
    <label for="tab-1" class="tab-label-1">Establecer Comunicación</label>
   
    <input id="tab-2" type="radio" name="radio-set" class="tab-selector-2" />
    <label for="tab-2" class="tab-label-2">Mapa de Recursos Sanitarios</label>
                           
    <div class="content">
        <div class="content-1">
        <p>La acciones recomendadas para un aviso de criticidad <c:out value="${aviso.criticidad}"></c:out> son: </p>
        <br>
        <c:if test="${aviso.criticidad eq 'Baja'}">
        	<p><ul style="list-style-type:disc" >
        		<li>Enviar correo electrónico al cuidador:</li>
        	</ul></p>
        	<form action="/sendEmail" method="post" class="mailform">
        		<table border="0" width="35%" align="center">
        			<tr>
        				<td width="50%">Destinatario</td>
        				<td><input type="text" 
        						name="recipient"
        						size="75" 
        						<c:if test="${not empty relative && not empty relative.relativeemail}">
        							value=<c:out value="${relative.relativeemail}"></c:out>
        						</c:if>
        						/>
        						</td>
        			</tr>
        			<tr>
        				<td>Asunto</td>
        				<td><input type="text" 
        						name="subject"
        						size="75"
        						maxLength="255"
        						value="iCare: El paciente <c:out value="${patient.patientname} ${patient.lastname}"></c:out> ha presentado el aviso <c:out value="${aviso.description}"></c:out>"/>
        				</td>
        			</tr>
        			<tr>
        				<td>Contenido</td>
        				<td><textarea rows="10" cols="77" name="content"></textarea></td>
        			</tr>
        			<tr>
        				<td colspan="2" align="center"><input type="submit" value="Enviar"/></td>
        			</tr>
        		</table>
        	</form>
        	<p><ul style="list-style-type:disc" >
        		<li>Ponerse en contacto con el paciente:</li>
        	</ul></p>
        	<p>Nombre del paciente: <span><c:out value="${patient.patientname} "></c:out> <c:out value="${patient.lastnamename}"></c:out></span></p>
        	<p>Teléfono Móvil: <c:out value="${patient.mobilephone}"></c:out></p>
        	<p>Teléfono Fijo: <c:out value="${patient.landlinephone}"></c:out></p>
        </c:if>
        <c:if test="${aviso.criticidad eq 'Media'}">
        	<p><ul style="list-style-type:disc" >
        		<li>Llamar inmediatamente al cuidador:</li>
        	</ul></p>
        	<p>Nombre del cuidador: <span><c:out value="${relative.relativename} "> </c:out><c:out value="${relative.lastname}"></c:out></span></p>
        	<p>Teléfono Móvil: <c:out value="${relative.mobilephone}"></c:out></p>
        	<p>Teléfono Fijo: <c:out value="${relative.landlinephone}"></c:out></p>
        	<p><ul style="list-style-type:disc" >
        		<li>Ponerse en contacto con el paciente:</li>
        	</ul></p>
        	<p>Nombre del paciente: <span><c:out value="${patient.patientname} "> </c:out><c:out value="${patient.lastname}"></c:out></span></p>
        	<p>Teléfono Móvil: <c:out value="${patient.mobilephone}"></c:out><p/>
        	<p>Teléfono Fijo: <c:out value="${patient.landlinephone}"></c:out></p>
        </c:if>
        <c:if test="${aviso.criticidad eq 'Alta'}">
        	<p><ul style="list-style-type:disc" >
        		<li>Llamar inmediatamente al cuidador:</li>
        	</ul></p>
        	<p>Nombre del cuidador: <span><c:out value="${relative.relativename} "> </c:out><c:out value="${relative.lastname}"></c:out></span></p>
        	<p>Teléfono Móvil: <c:out value="${relative.mobilephone}"></c:out></p>
        	<p>Teléfono Fijo: <c:out value="${relative.landlinephone}"></c:out></p>
        	<p><ul style="list-style-type:disc" >
        		<li>Llamar inmediatamente a servicios de emergencias:</li>
        	</ul><p>
       		<p>Teléfono de Emergencias: 112</p>
        	<p>Teléfono de Bomberos: 080 y 085</p>
        </c:if>
<!--         Mostrar números de teléfono o vías de comunicación con paciente, cuidador o servicios de urgencias en función de criticidad del aviso -->
        </div>
        <div class="content-2">
          
		  <c:if test = "${patient.isAtHome}"> 
		      <p>El paciente se encuentra en su domicilio: </p>
		      <br>
	          <iframe src="https://www.google.com/maps/d/embed?mid=1BBDjRFMQu1qSF82NLGYeLRN_ifo" width="640" height="480"></iframe>
          </c:if>
          <c:if test = "${not patient.isAtHome}">
          <p>El paciente se encuentra fuera de su domicilio, esta es su última localización: </p>
          <br>
          <iframe src="https://www.google.com/maps/d/embed?mid=1KgP7WB9QwvujaG0NnD8KTxZZ2TU" width="640" height="480"></iframe>
          </c:if>
        </div>
        <!--div class="content-3">
        	<h3>Tensión</h3>
		    <div id="dashboard" style="width: 600px; height: 500px; float: left;">
		        <div id="tension" style="width: 600px; height: 450px;"></div>
		        <br><br><br>
		        <div id="filtro" style="margin-left: 50px; height: 50px;"></div>
		    </div>
		    <div id="tension-media" style="width: 600px; height: 450px; float: left;"></div>
        </div-->
    </div>
</div>
</body>
</html>