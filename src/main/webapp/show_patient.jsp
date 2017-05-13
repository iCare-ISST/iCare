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

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> 
<script>
    google.charts.load('current', {packages: ['corechart', 'controls', 'gauge']});
    google.charts.setOnLoadCallback(dibujarGraficoTension);
    google.charts.setOnLoadCallback(dibujarGraficoTensionMedia);
    google.charts.setOnLoadCallback(dibujarGraficoPulsaciones);
    google.charts.setOnLoadCallback(dibujarGraficoPulsacionesMedia);
    
    function dibujarGraficoTension() {
        // Tabla de datos: valores y etiquetas de la gráfica
        var data = new google.visualization.DataTable();
        data.addColumn('date', 'Tensión');
        data.addColumn('number', 'Máxima');
        data.addColumn('number', 'Mínima');
        data.addRows([
        	<c:forEach items = "${patient.tension}" var = "tensioni">
				[new Date(${tensioni.dateLong}), ${tensioni.tensionMax}, ${tensioni.tensionMin}],
			</c:forEach>
        ]);
        var dashboard = new google.visualization.Dashboard(document.getElementById('dashboard-tension'));
        var donutRangeSlider = new google.visualization.ControlWrapper({
            'controlType': 'DateRangeFilter',
            'containerId': 'filtro-tension',
            'options': {
                'filterColumnLabel': 'Tensión'
            }
        });

        var lineChart = new google.visualization.ChartWrapper({
            'chartType': 'LineChart',
            'containerId': 'tension',
            'options': {
                'width': 600,
                'height': 450,
                'pieSliceText': 'value',
                'title': 'Tensión',
                'curveType': 'function',
                'hAxis': { 'title': 'día' },
                'legend': { position: 'bottom' }
            }
        });

        // Dibujar el gráfico
        dashboard.bind(donutRangeSlider, lineChart);

        // Draw the dashboard.
        dashboard.draw(data);
    }

    function dibujarGraficoTensionMedia() {
        // Tabla de datos: valores y etiquetas de la gráfica
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Texto');
        data.addColumn('number', 'Tensión máxima');
        data.addColumn('number', 'Tensión mínima');
        data.addRows([
            ['Tensión', ${patient.tensionMaxMedia}, ${patient.tensionMinMedia}],
        ]);
        var options = {
            'title': 'Tensión media',
            'legend': { 'position': 'bottom' },
            'vAxis': { 'minValue': 0 }
        }

        // Dibujar el gráfico
        var chart = new google.visualization.ColumnChart(document.getElementById('tension-media'));
        chart.draw(data, options);
    }
    
    function dibujarGraficoPulsaciones() {
        // Tabla de datos: valores y etiquetas de la gráfica
        var data = new google.visualization.DataTable();
        data.addColumn('date', 'Pulsaciones');
        data.addColumn('number', 'Pulsaciones');
        data.addRows([
        	<c:forEach items = "${patient.pulsaciones}" var = "pulsacionesi">
				[new Date(${pulsacionesi.dateLong}), ${pulsacionesi.pulsaciones}],
			</c:forEach>
        ]);
        var dashboard = new google.visualization.Dashboard(document.getElementById('dashboard-pulsaciones'));
        var donutRangeSlider = new google.visualization.ControlWrapper({
            'controlType': 'DateRangeFilter',
            'containerId': 'filtro-pulsaciones',
            'options': {
                'filterColumnLabel': 'Pulsaciones'
            }
        });

        var lineChart = new google.visualization.ChartWrapper({
            'chartType': 'LineChart',
            'containerId': 'pulsaciones',
            'options': {
                'width': 600,
                'height': 450,
                'pieSliceText': 'value',
                'title': 'Pulsaciones',
                'curveType': 'function',
                'hAxis': { 'title': 'día' },
                'legend': { position: 'bottom' }
            }
        });

        // Dibujar el gráfico
        dashboard.bind(donutRangeSlider, lineChart);

        // Draw the dashboard.
        dashboard.draw(data);
    }

    function dibujarGraficoPulsacionesMedia() {
        // Tabla de datos: valores y etiquetas de la gráfica
        var data = google.visualization.arrayToDataTable([
            ['Label', 'Value'],
            ['lpm', ${patient.pulsacionesMedia}]]);
        var options = {
            'title': 'Pulsaciones media',
            'legend': { 'position': 'bottom' },
			'redFrom': 150,
			'redTo': 200,
            'yellowFrom': 100,
            'yellowTo': 150,
            'greenFrom': 60,
            'greenTo': 100,
            'minorTicks': 5,
            'min': 0,
            'max': 200
        }

        // Dibujar el gráfico
        var chart = new google.visualization.Gauge(document.getElementById('pulsaciones-media'));
        chart.draw(data, options);
    }
</script> 

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
          	  <p1 align=center>Datos médicos</p1></td>
	          <c:if test = "${not empty medicaldata.alergias}">
	          <tr><td><p1>Alergias: </p1></td><td><p1><c:out value = "${medicaldata.alergias}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.cardiopatias}">
	          <tr><td><p1>Cardiopatías: </p1></td><td><p1><c:out value = "${medicaldata.cardiopatias}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.cardiovasculares}">
	          <tr><td><p1>Problemas Cardiovasculares: </p1></td><td><p1><c:out value = "${medicaldata.cardiovasculares}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.mentales}">
	          <tr><td><p1>Problemas Mentales: </p1></td><td><p1><c:out value = "${medicaldata.mentales}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.gruposanguineo}">
	          <tr><td><p1>Grupo Sanguíneo: </p1></td><td><p1><c:out value = "${medicaldata.gruposanguineo}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.medicacion}">
	          <tr><td><p1>Medicación: </p1></td><td><p1><c:out value = "${medicaldata.medicacion}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.otrasafecciones}">
	          <tr><td><p1>Otras Afecciones: </p1></td><td><p1><c:out value = "${medicaldata.otrasafecciones}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.sobrepeso}"> 
	          <tr><td><p1>Sobrepeso: </p1></td><td><p1><c:out value = "${medicaldata.sobrepeso}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty medicaldata.invalidez}">
	          <tr><td><p1>Invalidez o problemas de movilidad:  </p1></td><td><p1><c:out value = "${medicaldata.invalidez}" /></p1></td></tr></c:if>
	          </table>
	          <p>
            <a href="/nuevosdatosmedicos?email=${patient.email}"> 
              <button type="button"> Editar Datos </button>
            </a>
          </p>
          </c:if>
          <c:if test = "${empty medicaldata}">
          <p1><h3>Datos Médicos:</h3></p1>
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
          	  <p1 align=center>Cuidadores</p1></td>
	          <c:if test = "${not empty relative.relativename}">
	          <tr><td><p1>Nombre:  </p1></td><td><p1><c:out value = "${relative.relativename}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty relative.lastname}">

	          <tr><td><p1>Apellidos:  </p1></td><td><p1><c:out value = "${relative.lastname}" /> </p1></td></tr></c:if>

	          
	          <c:if test = "${not empty relative.relativeemail}">
	          <tr><td><p1>Email:  </p1></td><td><p1><c:out value = "${relative.relativeemail}" /> </p1></td></tr></c:if>

	          <c:if test = "${not empty relative.mobilephone}">
	          <tr><td><p1>Teléfono Móvil:  </p1></td><td><p1><c:out value = "${relative.mobilephone}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty relative.landlinephone}">
	          <tr><td><p1>Teléfono Fijo:  </p1></td><td><p1><c:out value = "${relative.landlinephone}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty relative.address}">
	          <tr><td><p1>Dirección:  </p1></td><td><p1><c:out value = "${relative.address}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty relative.location}">
	          <tr><td><p1>Localidad:  </p1></td><td><p1><c:out value = "${relative.location}" /> </p1></td></tr></c:if>
	          <c:if test = "${not empty relative.province}">
	          <tr><td><p1>Provincia:  </p1></td><td><p1><c:out value = "${relative.province}" /> </p1></td></tr></c:if>
	          </table>
	          <p>
            <a href="/nuevocuidador?email=${patient.email}"> 
              <button type="button"> Editar Datos </button>
            </a>
              <form method="post" action="/borrarCuidador" accept-charset="utf-8">
			  	<input type="hidden" name="email" value="${patient.email}"/>
			  	<input type="submit" id="borrardatoscuidador" value="Borrar Datos"/>
  			  </form>
          </p>
          </c:if>
          <c:if test = "${empty relative}">
          <p1><h3>Cuidadores:</h3></p1>
          <p>
            <a href="/nuevocuidador?email=${patient.email}"> 
              <button type="button"> Añadir datos de cuidador </button>
            </a>
          </p>      
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
<div class="tension">
	<h1>Tensión</h1>
	<div id="dashboard-tension">
	    <div id="tension"></div>
	    <br><br><br>
	    <div id="filtro-tension"></div>
	</div>
	<div id="tension-media"></div>
	<a href="/medirTension?patient=${patient.email}"><button>Medir tensión</button></a>
</div>

<div class="pulsaciones" >
	<h1>Pulsaciones</h1>
	<div id="dashboard-pulsaciones">
	    <div id="pulsaciones"></div>
	    <br><br><br>
	    <div id="filtro-pulsaciones"></div>
	</div>
	<div id="pulsaciones-media"></div>
</div>
<a href="/" class="myButton">Volver</a>
</body>
</html>