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
				<h1><spring:message code="label.perfil" /></h1>
				<div style="height: 300px">
					<div class="izquierda" id="perfil-imagen-edit">
						<ul style="padding: 0;">
							<li><h4><spring:message code="label.seguidores" />: <c:out value="${perfil.perfilObj.numSeguidores}"></c:out></h4></li>
							<li class="img-perfil-normal">
								<c:choose>
									<c:when test="${perfil.nick == usuario.nick}">
										<c:choose>
											<c:when test="${fotoPerfil != null}">
												<img alt="Imagen de perfil" src="data:image/jpeg;base64,${fotoPerfil}" class="img-circulo">
											</c:when>
											<c:otherwise>
												<img src="img/default.jpg" class="img-circulo" alt="default">
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${contacto.imgPerfil != null}">
												<img alt="Imagen de perfil" src="data:image/jpeg;base64,${contacto.imgPerfil}" class="img-circulo">
											</c:when>
											<c:otherwise>
												<img src="img/default.jpg" class="img-circulo" alt="default">
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</li>
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
														<c:choose>
															<c:when test="${numeroEstrella <= estrellas}">
																<td><span class="icon-star-empty estrellaActiva cursor-pointer centrar" id="estrella${numeroEstrella}" onclick="rankeaUsuario('estrella',${numeroEstrella},'numeroEstrellas','${usuario.nick}','${perfil.nick}');"></span></td>
															</c:when>
															<c:otherwise>
																<td><span class="icon-star-empty estrella cursor-pointer centrar" id="estrella${numeroEstrella}" onclick="rankeaUsuario('estrella',${numeroEstrella},'numeroEstrellas','${usuario.nick}','${perfil.nick}');"></span></td>
															</c:otherwise>
														</c:choose>
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
							<li><b><spring:message code="label.seudo" />:</b> <c:out value="${perfil.nick}"></c:out></li>
							<li><b><spring:message code="label.nombre" />:</b> <c:out value="${perfil.nombre} ${perfil.paterno} ${perfil.materno}"></c:out></li>
							<li><b><spring:message code="label.email" />:</b> <c:out value="${perfil.correo}"></c:out></li>
							<li><b><spring:message code="label.redes" />:</b></li>
							<li>
								<ul>
									<c:forEach items="${redes}" var="redSocial">
										<li><a href="${redSocial.url}"><c:out value="${redSocial.redSocialObj.nombre}"></c:out></a></li>
									</c:forEach>
								</ul>
							</li>
							<li><b><spring:message code="label.pais" />:</b> <c:out value="${perfil.paisObj.nombre}"></c:out></li>
							<li>
								<c:choose>
									<c:when test="${perfil.sexo == 'M'}">
										<b><spring:message code="label.sexo" />:</b> <spring:message code="label.mujer" />
									</c:when>
									<c:otherwise>
										<b><spring:message code="label.sexo" />:</b> <spring:message code="label.hombre" />
									</c:otherwise>
								</c:choose>
							</li>
						</ul>
					</div>
					<c:choose>
						<c:when test="${perfil.nick == usuario.nick}">
							<form action="BuscarInformacionFormularios?metodoDeBusqueda=5&esAjax=false&direccion=PerfilUsuarioEditable.jsp&nickName=${usuario.nick}" method="POST" class="derecha">
								<input type="submit" class="boton-formulario centrar" value="<spring:message code="label.editarp" />">
							</form>
						</c:when>
						<c:otherwise>
							<form action="Acciones?accion=6&direccion=PerfilUsuario.jsp&seguir=${perfil.nick}" method="POST" class="derecha">
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
				<div class="contenido75 formato-texto">
					<h3><spring:message code="label.biografia" />:</h3>
					<p><c:out value="${perfil.perfilObj.descripcion}"></c:out></p>
				</div>
				<div class="contenedor-libros">
					<c:if test="${perfil.nick == usuario.nick}">
						<a href="NuevaObra.jsp">
							<div class="libro">
								<div class="portadaLibro">
									<img alt="libro" src="img/agregarObra.png">
								</div>
								<div class="descripcionLibro">
									<p><spring:message code="label.agregarlib" /></p>
								</div>
							</div>
						</a>
					</c:if>
					<c:forEach items="${obras}" var="obra">
						<a href="BuscarInformacionFormularios?metodoDeBusqueda=8&esAjax=false&direccion=PerfilObra.jsp&idObra=${obra.idObra}">
							<div class="libro">
								<div class="portadaLibro">
									<c:choose>
										<c:when test="${obra.portada != null}">
											<img alt="libro" src="data:image/jpeg;base64,${obra.portada}">
										</c:when>
										<c:otherwise>
											<img alt="libro" src="img/pd.png">
										</c:otherwise>
									</c:choose>
								</div>
								<div class="descripcionLibro">
									<p><c:out value="${obra.titulo}"></c:out></p>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>