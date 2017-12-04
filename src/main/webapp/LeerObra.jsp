<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<!-- Estilos css -->
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/labelStyle.css">
	<link rel="stylesheet" type="text/css" href="css/ClassStyle.css">
	<link rel="stylesheet" type="text/css" href="css/IdStyle.css">
	<!-- Estilos css -->

	<!-- JavaScript -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/general.js"></script>
	<script type="text/javascript" src="js/carga-cabecera.js"></script>
	<script type="text/javascript" src="js/buscarInformacionAjax.js"></script>
	<!-- JavaScript -->
	<title>SocialWriters</title>
</head>
<body>
	<header>
		<div id="cabecera"></div>
	</header>
	<div class="menu-filtros" id="menu-lista-filtros"></div>
	<div class="contenedor">
		<div class="cabeceraCapitulos">
			<div class="izquierda" style="height: 150px;">
				<a href="BuscarInformacionFormularios?metodoDeBusqueda=8&esAjax=false&direccion=PerfilObra.jsp&idObra=${obra.id}">
					<c:choose>
						<c:when test="${detallesObra.portada != null}">
							<img alt="Imagen de perfil" src="data:image/jpeg;base64,${detallesObra.portada}">
						</c:when>
						<c:otherwise>
							<img src="img/pd.png" alt="default">
						</c:otherwise>
					</c:choose>
				</a>
			</div>
			<div class="izquierda">
				<ul>
					<li><h1><spring:message code="label.titulo"></spring:message>:  <a href="BuscarInformacionFormularios?metodoDeBusqueda=8&esAjax=false&direccion=PerfilObra.jsp&idObra=${obra.id}"><c:out value="${detallesObra.titulo}"></c:out></a></h1></li>
					<li><b><spring:message code="label.sinopsis"></spring:message>: </b></li>
					<li><c:out value="${obra.sinopsis}"></c:out></li>
				</ul>
			</div>
			<div class="izquierda">
				<select name="idCapitulo" id="capitulosItem" onchange="cargarCapitulo('capitulosItem');">
					<c:forEach items="${capitulosObra}" var="capituloSig">
						<option value="idObra=${detallesObra.idObra}&idCapitulo=${capituloSig.id}"><c:out value="${capituloSig.numero} ${capituloSig.nombre}"></c:out></option>
					</c:forEach>
				</select>
			</div>
			<div class="izquierda">
				<form action="Denuncia.jsp?idObra=${detallesObra.idObra}&idCapitulo=${capitulo.id}" method="POST" class="derecha">
					<input type="submit" class="boton-formulario centrar" value="<spring:message code="label.reportarobra" />">
				</form>
			</div>
		</div>
		<div class="contenido">
			<div class="fondoFormato">
				<h1 class="centrar"><c:out value="${capitulo.numero}.- ${capitulo.nombre}"></c:out></h1>
				<br>
				<c:forEach items="${capituloListaTexto}" var="parrafo">
					<p><c:out value="${parrafo}"></c:out></p>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>