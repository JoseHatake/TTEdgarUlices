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
		<div class="contenido">
			<div class="fondoFormato">
				<h1><spring:message code="label.obrap" /></h1>
				<div style="height: 300px">
					<div class="izquierda" id="perfil-imagen-edit">
						<div class="img-perfil-normal">
							<c:choose>
								<c:when test="${detallesObra.portada != null}">
									<img alt="Imagen de perfil" src="data:image/jpeg;base64,${detallesObra.portada}">
								</c:when>
								<c:otherwise>
									<img src="img/pd.png" alt="default">
								</c:otherwise>
							</c:choose>
						</div>
						<table>
							<c:choose>
								<c:when test="${detallesObra.nickAutor == usuario.nick}">
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
												<c:choose>
													<c:when test="${numeroEstrella <= estrellas}">
														<td><span
															class="icon-star-empty estrellaActiva cursor-pointer centrar"
															id="estrella${numeroEstrella}"
															onclick="rankeaObraUsuario('estrella',${numeroEstrella},'numeroEstrellas','${usuario.nick}','${obra.id}');"></span></td>
													</c:when>
													<c:otherwise>
														<td><span
															class="icon-star-empty estrella cursor-pointer centrar"
															id="estrella${numeroEstrella}"
															onclick="rankeaObraUsuario('estrella',${numeroEstrella},'numeroEstrellas','${usuario.nick}','${obra.id}');"></span></td>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</tr>
									</tbody>
								</c:otherwise>
							</c:choose>
						</table>
						<input type="hidden" id="numeroEstrellas" name="estrellas" value="${estrellas}">
					</div>
					<div class="derecha" id="perfil-info-edit">
						<ul>
							<li><b><spring:message code="label.titulo" />:</b> <c:out value="${obra.nombre}"></c:out></li>
							<li><b><spring:message code="label.idioma" />: </b><c:out value="${obra.idiomaObj.idioma}"></c:out></li>
							<li><b><spring:message code="label.autor" />: </b><a href="BuscarInformacionFormularios?metodoDeBusqueda=4&esAjax=false&direccion=PerfilUsuario.jsp&nickName=${detallesObra.nickAutor}"><c:out value="${obra.usuarioObj.nick}"></c:out></a></li>
							<li><b><spring:message code="label.generos" />:</b></li>
							<li>
								<ul>
									<c:forEach items="${generos}" var="genero">
										<li><spring:message code="label.genero${genero.generosObj.id}"></spring:message></li>
									</c:forEach>
								</ul>
							</li>
							<li><b><spring:message code="label.sinopsis" />:</b></li>
							<li><c:out value="${obra.sinopsis}"></c:out></li>
						</ul>
					</div>
					<c:choose>
						<c:when test="${detallesObra.nickAutor == usuario.nick}">
							<form action="BuscarInformacionFormularios?metodoDeBusqueda=8&esAjax=false&direccion=PerfilObraEditable.jsp&idObra=${detallesObra.idObra}" method="POST" class="derecha">
								<input type="submit" class="boton-formulario centrar" value="<spring:message code="label.editarobra" />">
							</form>
							<form action="CreaCapitulo.jsp?&idObra=${detallesObra.idObra}" method="POST" class="derecha">
								<input type="submit" class="boton-formulario centrar" value="<spring:message code="label.agregarcapitulo" />">
							</form>
						</c:when>
						<c:otherwise>
							<form action="Acciones?accion=7&direccion=PerfilObra.jsp&idObra=${detallesObra.idObra}&nickName=${usuario.nick}" method="POST" class="derecha">
								<c:choose>
									<c:when test="${siguiendo}">
										<input type="submit" class="boton-formulario centrar siguiendo" value="<spring:message code="label.dseguirp" />">
									</c:when>
									<c:otherwise>
										<input type="submit" class="boton-formulario centrar" value="<spring:message code="label.seguirp" />">
									</c:otherwise>
								</c:choose>
							</form>
						</c:otherwise>
					</c:choose>
				</div>
				<form action="BuscarInformacionFormularios?metodoDeBusqueda=9&esAjax=false&direccion=LeerObra.jsp&idObra=${detallesObra.idObra}&idCapitulo=0" method="POST">
					<input type="submit" class="boton-formulario centrar" value="<spring:message code="label.leer" />">
				</form>
			</div>
		</div>
	</div>
</body>
</html>