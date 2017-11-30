<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<!-- JavaScript -->
	<title>SocialWriters</title>
</head>
<body>
	<header>
		<div id="cabecera"></div>
	</header>
	<div class="menu-filtros" id="menu-lista-filtros"></div>
	<div class="contenedor">
		<div class="contenido">
			<div>
				<c:choose>
					<c:when test="${param.mensaje == 1}">
						<h1><spring:message code="label.activarcu" /></h1>
						<p><spring:message code="label.clickboton" /></p>
						<form action="Acciones?accion=1&direccion=MensajeUsuarioRegistrado.jsp" method="POST">
							<input type="hidden" name="id" value="${param.id}">
							<input type="hidden" name="nick" value="${param.nick}">
							<input type="submit" class="boton-formulario centrar" value="<spring:message code="label.activarcu" />">
						</form>
					</c:when>
					<c:when test="${mensaje == 2}">
						<h1><spring:message code="label.bienvenido" /> <c:out value="${usuario.nombre} ${usuario.paterno} ${usuario.materno}"></c:out></h1>
						<p><spring:message code="label.cuentaasoc" /> <c:out value="${usuario.correo}"></c:out> <spring:message code="label.quedadoactivada" /></p>
					</c:when>
					<c:when test="${mensaje == 3}">
						<h1><spring:message code="label.claveres" /></h1>
						<p><spring:message code="label.correoclave" /></p>
					</c:when>
					<c:when test="${mensaje == 4}">
						<h1><spring:message code="label.correoinvalido" /></h1>
						<p><spring:message code="label.correonoreg" /></p>
					</c:when>
					<c:when test="${mensaje == 5}">
						<h1><spring:message code="label.claveexito" /></h1>
						<p><spring:message code="label.clavecambiada" /></p>
					</c:when>
					<c:when test="${mensaje == 6}">
						<h1><spring:message code="label.claveactualmal" /></h1>
						<p><spring:message code="label.clavemalmen" /></p>
					</c:when>
					<c:otherwise>
						<h1><spring:message code="label.registrocompleto" /></h1>
						<p><spring:message code="label.correoactivacion" /></p>
					</c:otherwise>
					
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>