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
  <c:out value = "${patientname}" />
</p>

<p>
  <b>Apellidos</b>
  <c:out value = "${lastname}" />
</p>
<p>
  <b>Fecha de Nacimiento</b>
  <c:out value = "${birthdate}" />
</p>
<p>
  <b>Teléfono Móvil</b>
  <c:out value = "${mobilephone}" />
</p>
<p>
  <b>Teléfono Fijo</b>
<%--   <c:out value = "${mobilephone}" /> --%>
</p>
<p>
  <b>Dirección</b>
  <c:out value = "${adress}" />
</p>
<p>
  <b>Localidad</b>
  <c:out value = "${location}" />
</p>
<p>
  <b>Provincia</b>
<%--   <c:out value = "${mobilephone}" /> --%>
</p>

<p>
  <a href="#"> 
    <button type="button"> Editar </button>
  </a>  
  <a href="#"> 
    <button type="button"
            onClick="return confirm('Borrar cuenta: <c:out value = "${patientname}" />');">
       Borrar 
    </button>
  </a>
</p>
<div id="contenedor">
    <input id="tab-1" type="radio" name="radio-set" class="tab-selector-1" checked="checked" />
    <label for="tab-1" class="tab-label-1">Datos Médicos</label>
   
    <input id="tab-2" type="radio" name="radio-set" class="tab-selector-2" />
    <label for="tab-2" class="tab-label-2">Personas de Contacto</label>
                           
    <div class="content">
        <div class="content-1"><%-- 
          <% if (patient.MedicalDatum) { %> 
          <p>Alergias = <%= patient.MedicalDatum.alergias %></p>
          <p>Cardiopatías = <%= patient.MedicalDatum.cardiopatias %></p>
          <p>Problemas Cardiovasculares = <%= patient.MedicalDatum.cardiovasculares %></p>
          <p>Problemas Mentales = <%= patient.MedicalDatum.mentales %></p>
          <p>Grupo Sanguíneo = <%= patient.MedicalDatum.gruposanguineo %></p>
          <p>Medicación = <%= patient.MedicalDatum.medicacion %></p>
          <p>Otras Infecciones = <%= patient.MedicalDatum.otrasafecciones %></p>
          <p>Peso (kg) = <%= patient.MedicalDatum.peso %></p>
          <p>Invalidez o problemas de movilidad: = <%= patient.MedicalDatum.invalidez %></p>
          <p>
            <a href="#"> 
              <button type="button"> Editar Datos </button>
            </a>
          </p>
          <% } else { %>
          <p>
            <a href#"> 
              <button type="button"> Añadir nuevos Datos Médicos </button>
            </a>
          </p>      
          <% } %> --%>
        </div>
        <div class="content-2">
          <h3>Familiares:</h3>
<%--           <% if (patient.Relatives.length !== 0) { %>
              <% for(var i in patient.Relatives) { %>
                <p>Nombre:<%= patient.Relatives[i].name %> </p>
                <p>Apellidos:<%= patient.Relatives[i].lastname %> </p>
                <p>Teléfono Móvil: <%= patient.Relatives[i].mobilephone %> </p>
                <p>Teléfono Fijo: <%= patient.Relatives[i].landlinephone %> </p>
                <a href="/relatives/<%= patient.Relatives[i].id %>"> 
                  <button type="button"> Ver más Información de Contacto </button>
                </a>
                <a href="/relatives/<%= patient.Relatives[i].id %>/edit"> 
                  <button type="button"> Editar Datos de Contacto </button>
                </a>
              <% } %>  
          <% } else { %>
              <p>
              <a href="#"> 
                <button type="button"> Añadir Nuevas Personas de Contacto </button>
              </a>
              <a href="#"> 
                <button type="button"> Asignar Personas de Contacto </button>
              </a>
              </p>      
          <% } %> --%>
        </div>
    </div>
</div>

<a href="/"> 
   <button type="button">Volver</button>
</a>
</body>
</html>