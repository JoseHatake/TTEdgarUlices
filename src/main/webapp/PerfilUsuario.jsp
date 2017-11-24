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
							<li><h4>Seguidores: <c:out value="${perfil.perfilObj.numSeguidores}"></c:out></h4></li>
							<li><img src="img/default.jpg" class="img-circulo" alt="default"></li>
							<li>
								<table>
									<c:choose>
										<c:when test="${perfil.nick == usuario.nick}">
											<tbody>
												<tr>
													<c:forEach var="activa" begin="1" end="5">
														<c:choose>
															<c:when test="${activa <= estrellas}">
																<td><span class="icon-star-empty estrellaActiva centrar" id="estrella${activa}"></span></td>
															</c:when>
															<c:otherwise>
																<td><span class="icon-star-empty estrella centrar" id="estrella${activa}"></span></td>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</tr>
											</tbody>
										</c:when>
										<c:otherwise>
											<tbody>
												<tr>
													<c:forEach var="numeroEstrella" begin="1" end="5">
														<td><span class="icon-star-empty estrella cursor-pointer centrar" id="estrella${numeroEstrella}" onclick="styleStarts('estrella',${numeroEstrella},'numeroEstrellas');"></span></td>
													</c:forEach>
												</tr>
											</tbody>
										</c:otherwise>
									</c:choose>
								</table>
								<input type="hidden" id="numeroEstrellas" name="estrellas" value="${estrellas}">
							</li>
						</ul>
					</div>
					<div class="derecha" id="perfil-info-edit">
						<ul>
							<li>Seudónimo: <c:out value="${perfil.nick}"></c:out></li>
							<li>Nombre: <c:out value="${perfil.nombre} ${perfil.paterno} ${perfil.materno}"></c:out></li>
							<li>Contacto:</li>
							<li>
								<ul>
									<li>Correo: <c:out value="${perfil.correo}"></c:out></li>
									<li>Redes sociales:</li>
									<c:forEach items="${redes}" var="redSocial">
										<li><a href="${redSocial.url}"><c:out value="${redSocial.nombre}"></c:out></a></li>
									</c:forEach>
								</ul>
							</li>
						</ul>
					</div>
					<c:if test="${perfil.nick == usuario.nick}">
						<form action="PerfilUsuarioEditable.jsp">
							<input type="submit" class="boton-formulario centrar" value="Editar perfil">
						</form>
					</c:if>
				</div>
				<div class="contenido75 formato-texto">
					<h3>Descripción:</h3>
					<p><c:out value="${perfil.perfilObj.descripcion}"></c:out></p>
				</div>
				<div class="contenedor-libros">
					<c:if test="${perfil.nick == usuario.nick}">
						<a href="NuevaObra.jsp">
							<div class="libro">
								<div class="portadaLibro">
									<img alt="libro" src="img/agregar.png">
								</div>
								<div class="descripcionLibro">
									<p>Agregar libro</p>
								</div>
							</div>
						</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>