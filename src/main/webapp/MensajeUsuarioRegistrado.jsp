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
						<h1>Activar cuenta</h1>
						<p>Para activar tu cuenta da click en el siguiente bot�n.</p>
						<form action="BuscarInformacionFormularios?metodoDeBusqueda=4&esAjax=false&direccion=MensajeUsuarioRegistrado.jsp" method="POST">
							<input type="hidden" name="id" value="${param.id}">
							<input type="hidden" name="nick" value="${param.nick}">
							<input type="submit" class="boton-formulario centrar" value="Activar cuenta">
						</form>
					</c:when>
					<c:when test="${mensaje == 2}">
						<h1>Bienvenido <c:out value="${usuario.nombre} ${usuario.paterno} ${usuario.materno}"></c:out></h1>
						<p>Tu cuenta asociada al correo <c:out value="${usuario.correo}"></c:out> a quedado activada, ahora ya puedes iniciar sesi�n.</p>
					</c:when>
					<c:otherwise>
						<h1>Registro completo</h1>
						<p>Te hemos enviado un correo para que actives tu cuenta.</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>