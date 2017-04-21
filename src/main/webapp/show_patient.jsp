<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>Vista de Paciente</title>
</head>
<body>

<h2>Paciente</h2>

<p>
  <b>Nombre de Paciente:</b>
  <c:out value = "${patient.patientname}" />
</p>

<p>
  <b>Apellidos:</b>
  <c:out value = "${patient.lastname}" />
</p>
<p>
  <b>Fecha de Nacimiento:</b>
  <c:out value = "${patient.birthdate}" />
</p>
<p>
  <b>Teléfono Móvil:</b>
  <c:out value = "${patient.mobilephone}" />
</p>
<p>
  <b>Teléfono Fijo:</b>
   <c:out value = "${patient.landlinephone}" /> 
</p>
<p>
  <b>Dirección:</b>
  <c:out value = "${patient.address}" />
</p>
<p>
  <b>Localidad:</b>
  <c:out value = "${patient.location}" />
</p>
<p>
  <b>Provincia:</b>
  <c:out value = "${patient.province}" /> 
</p>

<p>
  <a href="#"> 
    <button type="button"> Editar </button>
  </a>  
  <form method="post" action="/borrarPaciente" accept-charset="utf-8">
  	<input type="hidden" name="email" value="${patient.email}"/>
  	<input type="submit" value="Borrar"/>
  </form>
</p>
<div id="contenedor">
    <input id="tab-1" type="radio" name="radio-set" class="tab-selector-1" checked="checked" />
    <label for="tab-1" class="tab-label-1">Datos Médicos</label>
   
    <input id="tab-2" type="radio" name="radio-set" class="tab-selector-2" />
    <label for="tab-2" class="tab-label-2">Personas de Contacto</label>
                           
    <div class="content">
        <div class="content-1">
        <h3>Datos Médicos:</h3>
          <c:if test = "${not empty medicaldata}"> 
	          <p>Alergias: <c:out value = "${medicaldata.alergias}" /> </p>
	          <p>Cardiopatías: <c:out value = "${medicaldata.cardiopatias}" /> </p>
	          <p>Problemas Cardiovasculares: <c:out value = "${medicaldata.cardiovasculares}" /> </p>
	          <p>Problemas Mentales: <c:out value = "${medicaldata.mentales}" /> </p>
	          <p>Grupo Sanguíneo: <c:out value = "${medicaldata.gruposanguineo}" /> </p>
	          <p>Medicación: <c:out value = "${medicaldata.medicacion}" /> </p>
	          <p>Otras Afecciones: <c:out value = "${medicaldata.otrasafecciones}" /> </p>
	          <p>Sobrepeso: <c:out value = "${medicaldata.sobrepeso}" /> </p>
	          <p>Invalidez o problemas de movilidad:  <c:out value = "${medicaldata.invalidez}" /></p>
	          <p>
            <a href="#"> 
              <button type="button"> Editar Datos </button>
            </a>
          </p>
          </c:if>
          <c:if test = "${empty medicaldata}">
          <p>
            <a href="/nuevosdatosmedicos"> 
              <button type="button"> Añadir nuevos Datos Médicos </button>
            </a>
          </p>      
          </c:if>
        </div>
        <div class="content-2">
          <h3>Familiares:</h3>
		  <c:if test = "${not empty relative}"> 
	          <p>Nombre: <c:out value = "${relative.relativename}" /> </p>
	          <p>Apellidos: <c:out value = "${relative.lastname}" /> </p>
	          <p>Teléfono Móvil: <c:out value = "${relative.mobilephone}" /> </p>
	          <p>Teléfono Fijo: <c:out value = "${relative.landlinephone}" /> </p>
	          <p>Dirección: <c:out value = "${relative.address}" /> </p>
	          <p>Localidad: <c:out value = "${relative.location}" /> </p>
	          <p>Provincia: <c:out value = "${relative.province}" /> </p>
	          <p>
            <a href="#"> 
              <button type="button"> Editar Datos </button>
            </a>
          </p>
          </c:if>
          <c:if test = "${empty relative}">
          <p>
            <a href="/nuevocuidador"> 
              <button type="button"> Añadir datos de cuidador </button>
            </a>
          </p>      
          </c:if>
        </div>
    </div>
</div>

<a href="/"> 
   <button type="button">Volver</button>
</a>
</body>
</html>