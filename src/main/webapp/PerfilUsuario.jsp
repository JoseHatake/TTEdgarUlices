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
	<script type="text/javascript" src="js/validaciones.js"></script>
	<script type="text/javascript" src="js/fechas.js"></script>
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
			<div class="fondoFormato">
				<div style="height: 250px">
					<div class="izquierda" id="perfil-imagen-edit">
						<ul>
							<li><h4>Seguidores: <c:out value="${usuario.perfilObj.numSeguidores}"></c:out></h4></li>
							<li><img src="img/default.jpg" class="img-circulo" alt="default"></li>
							<li>
								<table>
									<tbody>
										<tr>
											<td><span class="icon-star-empty estrella centrar" id="estrella1" onclick="styleStarts('estrella',1,'numeroEstrellas');"></span></td>
											<td><span class="icon-star-empty estrella centrar" id="estrella2" onclick="styleStarts('estrella',2,'numeroEstrellas');"></span></td>
											<td><span class="icon-star-empty estrella centrar" id="estrella3" onclick="styleStarts('estrella',3,'numeroEstrellas');"></span></td>
											<td><span class="icon-star-empty estrella centrar" id="estrella4" onclick="styleStarts('estrella',4,'numeroEstrellas');"></span></td>
											<td><span class="icon-star-empty estrella centrar" id="estrella5" onclick="styleStarts('estrella',5,'numeroEstrellas');"></span></td>
										</tr>
									</tbody>
								</table>
								<input type="hidden" id="numeroEstrellas" name="estrellas" value="0">
							</li>
						</ul>
					</div>
					<div class="derecha" id="perfil-info-edit">
						<ul>
							<li>Seudónimo: <c:out value="${usuario.nick}"></c:out></li>
							<li>Nombre: <c:out value="${usuario.nombre} ${usuario.paterno} ${usuario.materno}"></c:out></li>
							<li>Contacto:</li>
							<li>
								<ul>
									<li>Correo: <c:out value="${usuario.correo}"></c:out></li>
									<li>Redes sociales:</li>
									<c:forEach items="${param.redes}" var="redSocial">
										<li><a href="${redSocial.url}"><c:out value="${redSocial.nombre}"></c:out></a></li>
									</c:forEach>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				<div class="contenido75 formato-texto">
					<h3>Descripción:</h3>
					<p><c:out value="${usuario.perfilObj.descripcion}"></c:out></p>
				</div>
				<div class="contenedor-libros"></div>
			</div>
		</div>
	</div>
</body>
</html>