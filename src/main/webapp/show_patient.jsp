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

<p id="aviso"><a href="/crearAviso?patient=${patient.email}"><button>Aviso</button></a></p>
<table border=2  style="margin: 0 auto;">
<c:if test = "${not empty patient.patientname}">
<tr><td><p>
  <b>Nombre de Paciente:</b></td><td><p>
  <c:out value = "${patient.patientname}" />
</p></td></tr></c:if>
<c:if test = "${not empty patient.lastname}">
<tr><td><p>
  <b>Apellidos:</b></td><td><p>
  <c:out value = "${patient.lastname}" />
</p></td></tr></c:if>
<c:if test = "${not empty patient.birthdate}">
<tr><td><p>
  <b>Fecha de Nacimiento:</b></td><td><p>
  <c:out value = "${patient.birthdate}" />
</p></td></tr></c:if>
<c:if test = "${not empty patient.mobilephone}">
<tr><td><p>
  <b>Teléfono Móvil:</b></td><td><p>
  <c:out value = "${patient.mobilephone}" />
</p></td></tr></c:if>
<c:if test = "${not empty patient.landlinephone}">
<tr><td><p>
  <b>Teléfono Fijo:</b></td><td><p>
   <c:out value = "${patient.landlinephone}" /> 
</p></td></tr></c:if>
<c:if test = "${not empty patient.address}">
<tr><td><p>
  <b>Dirección:</b></td><td><p>
  <c:out value = "${patient.address}" />
</p></td></tr></c:if>
<c:if test = "${not empty patient.location}">
<tr><td><p>
  <b>Localidad:</b></td><td><p>
  <c:out value = "${patient.location}" />
</p></td></tr></c:if>
<c:if test = "${not empty patient.province}">
<tr><td><p>
  <b>Provincia:</b></td><td><p>
  <c:out value = "${patient.province}" /> 
</p></td></tr></c:if>
</table>
<p>
  <a href="/nuevoPaciente?email=${patient.email}"> 
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
        
          <c:if test = "${not empty medicaldata}"> 
	          <table border=2  style="margin: 0 auto;">
	          <td colspan="2" style="font: oblique bold 120% cursive">
          	  <p align=center>Datos médicos</p></td>
	          <c:if test = "${not empty medicaldata.alergias}">
	          <tr><td><p>Alergias: </td><td><p><c:out value = "${medicaldata.alergias}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.cardiopatias}">
	          <tr><td><p>Cardiopatías: </td><td><p><c:out value = "${medicaldata.cardiopatias}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.cardiovasculares}">
	          <tr><td><p>Problemas Cardiovasculares: </td><td><p><c:out value = "${medicaldata.cardiovasculares}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.mentales}">
	          <tr><td><p>Problemas Mentales: </td><td><p><c:out value = "${medicaldata.mentales}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.gruposanguineo}">
	          <tr><td><p>Grupo Sanguíneo: </td><td><p><c:out value = "${medicaldata.gruposanguineo}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.medicacion}">
	          <tr><td><p>Medicación: </td><td><p><c:out value = "${medicaldata.medicacion}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.otrasafecciones}">
	          <tr><td><p>Otras Afecciones: </td><td><p><c:out value = "${medicaldata.otrasafecciones}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.sobrepeso}"> 
	          <tr><td><p>Sobrepeso: </td><td><p><c:out value = "${medicaldata.sobrepeso}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.invalidez}">
	          <tr><td><p>Invalidez o problemas de movilidad:  </td><td><p><c:out value = "${medicaldata.invalidez}" /></p></td></tr></c:if>
	          </table>
	          <p>
            <a href="/nuevosdatosmedicos?email=${patient.email}"> 
              <button type="button"> Editar Datos </button>
            </a>
          </p>
          </c:if>
          <c:if test = "${empty medicaldata}">
          <h3>Datos Médicos:</h3>
          <p>
            <a href="/nuevosdatosmedicos?email=${patient.email}"> 
              <button type="button"> Añadir nuevos Datos Médicos </button>
            </a>
          </p>      
          </c:if>
        </div>
        <div class="content-2">
          
		  <c:if test = "${not empty relative}"> 
	          <table border=2  style="margin: 0 auto;">
	          <td colspan="2" style="font: oblique bold 120% cursive">
          	  <p align=center>Cuidadores</p></td>
	          <c:if test = "${not empty relative.relativename}">
	          <tr><td><p>Nombre:  </td><td><p><c:out value = "${relative.relativename}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty relative.lastname}">
	          <tr><td><p>Apellidos:  </td><td><p><c:out value = "${relative.lastname}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty relative.mobilephone}">
	          <tr><td><p>Teléfono Móvil:  </td><td><p><c:out value = "${relative.mobilephone}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty relative.landlinephone}">
	          <tr><td><p>Teléfono Fijo:  </td><td><p><c:out value = "${relative.landlinephone}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty relative.address}">
	          <tr><td><p>Dirección:  </td><td><p><c:out value = "${relative.address}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty relative.location}">
	          <tr><td><p>Localidad:  </td><td><p><c:out value = "${relative.location}" /> </p></td></tr></c:if>
	          <c:if test = "${not empty relative.province}">
	          <tr><td><p>Provincia:  </td><td><p><c:out value = "${relative.province}" /> </p></td></tr></c:if>
	          </table>
	          <p>
            <a href="/nuevocuidador?email=${patient.email}"> 
              <button type="button"> Editar Datos </button>
            </a>
              <form method="post" action="/borrarCuidador" accept-charset="utf-8" class="borrarC">
			  	<input type="hidden" name="email" value="${patient.email}"/>
			  	<input type="submit" value="Borrar Datos"/>
  			  </form>
          </p>
          </c:if>
          <c:if test = "${empty relative}">
          <h3>Cuidadores:</h3>
          <p>
            <a href="/nuevocuidador?email=${patient.email}"> 
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