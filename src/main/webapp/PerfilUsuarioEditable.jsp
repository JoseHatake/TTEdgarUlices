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
				<h1>Editar perfil</h1>
				<form action="EditarPerfil" method="POST">
					<div style="height: 550px;">
						<div style="width: 250px;height: 250px;margin-right: 50px; margin-bottom: 50px;" class="izquierda">
							<img src="img/default.jpg" id="foto" class="img-circulo" alt="default">
							<input type="file" accept="image/*" id="origenFoto" name="foto" onchange="cambiaFoto('origenFoto','foto');">
						</div>
						<table class="izquierda">
							<tbody>
								<tr>
									<td class="form-espacio">
										<input type="text" name="usuario" id="campoUsuario" class="form-input-text" value="${usuario.nick}" placeholder="Usuario" minlength="5" maxlength="20" onkeyup="usuarioDisponible('campoUsuario','campoUsuarioFijo','itemSubmit');" required>
										<input type="hidden" id="campoUsuarioFijo" value="${usuario.nick}">
									</td>
								</tr>
								<tr>
									<td class="form-espacio" colspan="2"><input type="text" name="nombre" class="form-input-text" value="${usuario.nombre}" placeholder="<spring:message code="label.nombre"/>" maxlength="45" required></td>
								</tr>
								<tr>
									<td class="form-espacio"><input type="text" name="apellidoPaterno" class="form-input-text" value="${usuario.paterno}" placeholder="Apelido Paterno" maxlength="30" required></td>
									<td class="form-espacio"><input type="text" name="apellidoMaterno" class="form-input-text" value="${usuario.materno}" placeholder="Apelido Materno" maxlength="30" required></td>
								</tr>
								<tr>
									<td class="form-espacio" colspan="2">
										<input type="email" name="correo" id="correo1" class="form-input-text" value="${usuario.correo}" placeholder="Correo electrónico" minlength="7" maxlength="80" onkeyup="validaCorreosIguales('correo1','correo2','correoFijo','itemSubmit');" required>
										<input type="hidden" id="correoFijo" value="${usuario.correo}">
									</td>
								</tr>
								<tr>
									<td class="form-espacio" colspan="2"><input type="email" id="correo2" class="form-input-text" value="${usuario.correo}" placeholder="Confirmar correo" minlength="7" maxlength="80" onkeyup="validaCorreosIguales('correo1','correo2','correoFijo','itemSubmit');" required></td>
								</tr>
								<tr>
									<td class="form-espacio" colspan="2">
										<select class="form-input-lista" name="pais" required="required">
											<option value="">Pais</option>
											<c:forEach items="${paises}" var="pais">
												<c:choose>
													<c:when test="${pais.id == usuario.idPais}">
														<option value="${pais.id}" selected>${pais.nombre}</option>
													</c:when>
													<c:otherwise>
														<option value="${pais.id}">${pais.nombre}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td class="form-espacio" colspan="2"><h3>Fecha de nacimiento</h3></td>
								</tr>
								<tr>
									<td class="form-espacio">
										<input type="date" class="form-input-text" name="fechaNacimiento" value="${usuario.fechaNacimiento}" placeholder="AAAA/MM/DD">
									</td>
								</tr>
								<tr>
									<td class="form-espacio">
										<c:choose>
											<c:when test="${usuario.sexo == 'M'}">
												<input type="radio" name="sexo" value="M" checked required> Mujer
												<input type="radio" name="sexo" value="H" required> Hombre
											</c:when>
											<c:otherwise>
												<input type="radio" name="sexo" value="M" required> Mujer
												<input type="radio" name="sexo" value="H" checked required> Hombre
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
								<tr>
									<td><h3>Redes sociales</h3></td>
								</tr>
								<c:forEach items="${catalogoRedes}" var="redSocialCatalogo">
									<c:set var="flag" value="true"></c:set>
									<c:forEach items="${redes}" var="redesSociales">
										<c:if test="${redesSociales.idRedSocial == redSocialCatalogo.id}">
											<tr>
												<td class="form-espacio" colspan="2"><input type="text" class="form-input-text" maxlength="255" name="${redSocialCatalogo.nombre}" value="${redesSociales.url}" placeholder="URL ${redSocialCatalogo.nombre}"></td>
											</tr>
											<c:set var="flag" value="false"></c:set>
										</c:if>
									</c:forEach>
									<c:if test="${flag}">
										<tr>
											<td class="form-espacio" colspan="2"><input type="text" class="form-input-text" maxlength="255" name="${redSocialCatalogo.nombre}" placeholder="URL ${redSocialCatalogo.nombre}"></td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="contenido75 formato-texto">
						<h3>Biografía:</h3>
						<input type="textarea" name="biografia" class="form-input-text" maxlength="255" value="${usuario.perfilObj.descripcion}" placeholder="Biografía del autor">
					</div>
					<table style="margin-top: 20px;">
						<tbody>
							<tr>
								<td style="padding-right: 10px;"><a href="BuscarInformacionFormularios?metodoDeBusqueda=4&esAjax=false&direccion=PerfilUsuario.jsp&nickName=${usuario.nick}"><input type="button" class="boton-formulario centrar" value="Cancelar"></a></td>
								<td style="padding-left: 10px;"><input type="submit" class="boton-formulario centrar" id="itemSubmit" value="Guardar"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>