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
				<div style="height: 250px;">
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
								<c:when test="${detallesObra.nickAutor == usuario.nick || usuario == null}">
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
										<tr>
											<div id="fb-root"></div>
											<script>(function(d, s, id) {
											  var js, fjs = d.getElementsByTagName(s)[0];
											  if (d.getElementById(id)) return;
											  js = d.createElement(s); js.id = id;
											  js.src = 'https://connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v2.11';
											  fjs.parentNode.insertBefore(js, fjs);
											}(document, 'script', 'facebook-jssdk'));</script>
											<div class="fb-share-button" data-href="http://localhost:8080/SocialWriters/BuscarInformacionFormularios?metodoDeBusqueda=8&amp;esAjax=false&amp;direccion=PerfilObra.jsp&amp;idObra=${obra.id}" data-layout="button" data-size="small" data-mobile-iframe="true"><a class="fb-xfbml-parse-ignore" target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Flocalhost%3A8080%2FSocialWriters%2FBuscarInformacionFormularios%3FmetodoDeBusqueda%3D8%26esAjax%3Dfalse%26direccion%3DPerfilObra.jsp%26idObra&amp;src=sdkpreparse">Compartir</a></div>
											<a href="https://twitter.com/share?ref_src=twsrc%5Etfw" class="twitter-share-button" data-show-count="false">Tweet</a><script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
											<div class="g-plus" data-action="share" data-href="http://localhost:8080/SocialWriters/BuscarInformacionFormularios?metodoDeBusqueda=8&amp;esAjax=false&amp;direccion=PerfilObra.jsp&amp;idObra=${obra.id}"></div>
											<script src="https://apis.google.com/js/platform.js" async defer>{lang: 'es'}</script>
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
															onclick="rankeaObraUsuario('estrella',${numeroEstrella},'numeroEstrellas','${usuario.id}','${obra.id}');"></span></td>
													</c:when>
													<c:otherwise>
														<td><span
															class="icon-star-empty estrella cursor-pointer centrar"
															id="estrella${numeroEstrella}"
															onclick="rankeaObraUsuario('estrella',${numeroEstrella},'numeroEstrellas','${usuario.id}','${obra.id}');"></span></td>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</tr>
										<tr>
											<div id="fb-root"></div>
											<script>(function(d, s, id) {
											  var js, fjs = d.getElementsByTagName(s)[0];
											  if (d.getElementById(id)) return;
											  js = d.createElement(s); js.id = id;
											  js.src = 'https://connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v2.11';
											  fjs.parentNode.insertBefore(js, fjs);
											}(document, 'script', 'facebook-jssdk'));</script>
											<div class="fb-share-button" data-href="http://localhost:8080/SocialWriters/BuscarInformacionFormularios?metodoDeBusqueda=8&amp;esAjax=false&amp;direccion=PerfilObra.jsp&amp;idObra=${obra.id}" data-layout="button" data-size="small" data-mobile-iframe="true"><a class="fb-xfbml-parse-ignore" target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Flocalhost%3A8080%2FSocialWriters%2FBuscarInformacionFormularios%3FmetodoDeBusqueda%3D8%26esAjax%3Dfalse%26direccion%3DPerfilObra.jsp%26idObra&amp;src=sdkpreparse">Compartir</a></div>
											<a href="https://twitter.com/share?ref_src=twsrc%5Etfw" class="twitter-share-button" data-show-count="false">Tweet</a><script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
											<div class="g-plus" data-action="share" data-href="http://localhost:8080/SocialWriters/BuscarInformacionFormularios?metodoDeBusqueda=8&amp;esAjax=false&amp;direccion=PerfilObra.jsp&amp;idObra=${obra.id}"></div>
											<script src="https://apis.google.com/js/platform.js" async defer>{lang: 'es'}</script>
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
							<c:if test="${siguiendo != null}">
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
							</c:if>
						</c:otherwise>
					</c:choose>
				</div>
				<form action="BuscarInformacionFormularios?metodoDeBusqueda=9&esAjax=false&direccion=LeerObra.jsp&idObra=${detallesObra.idObra}&idCapitulo=0" method="POST">
					<input type="submit" class="boton-formulario centrar" value="<spring:message code="label.leer" />">
				</form>
				<div class="contenedor-comentarios">
					<c:if test="${usuario != null}">
						<form action="Acciones?accion=8&direccion=PerfilObra.jsp&idObra=${detallesObra.idObra}" method="POST">
							<textarea name="comentario" style="width: 100%; height: 60px; margin-bottom: 20px;" maxlength="250"></textarea>
							<input type="submit" class="boton-formulario centrar" id="itemSubmit" value="<spring:message code="label.guardar" />">
						</form>
					</c:if>
					<div class="comentarios">
						<c:forEach items="${comentarios}" var="comentario">
							<div class="comentario-individual">
								<div class="img-perfil-mini">
									<c:choose>
										<c:when test="${comentario.contacto.imgPerfil != null}">
											<img src="data:image/jpeg;base64,${comentario.contacto.imgPerfil}" class="img-circulo" alt="default">
										</c:when>
										<c:otherwise>
											<img src="img/default.jpg" class="img-circulo" alt="default">
										</c:otherwise>
									</c:choose>
								</div>
								<div>
									<p class="fecha-comentario"><a href="BuscarInformacionFormularios?metodoDeBusqueda=4&esAjax=false&direccion=PerfilUsuario.jsp&nickName=${comentario.contacto.nickName}"><c:out value="${comentario.contacto.nickName}"></c:out></a> <c:out value="${comentario.fecha}"></c:out></p>
								</div>
								<p><c:out value="${comentario.comentario}"></c:out></p>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>