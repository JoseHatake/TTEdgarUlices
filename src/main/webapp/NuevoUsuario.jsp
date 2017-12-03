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
			<form action="RegistrarUsuario" class="centrar">
				<table class="form-config">
					<thead>
						<tr>
							<th><h2><spring:message code="label.crearc" /></h2></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="form-espacio"><input type="text" name="usuario" id="usuario" class="form-input-text" placeholder="<spring:message code="label.usuario" />" minlength="5" maxlength="20" onkeyup="usuarioDisponible('usuario','itemSubmit');" required></td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2"><input type="text" name="nombre" class="form-input-text" placeholder="<spring:message code="label.nombre" />" maxlength="45" required></td>
						</tr>
						<tr>
							<td class="form-espacio"><input type="text" name="apellidoPaterno" class="form-input-text" placeholder="<spring:message code="label.apaterno" />" maxlength="30" required></td>
							<td class="form-espacio"><input type="text" name="apellidoMaterno" class="form-input-text" placeholder="<spring:message code="label.amaterno" />" maxlength="30" required></td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2"><input type="email" name="correo" id="correo1" class="form-input-text" placeholder="<spring:message code="label.email" />" minlength="7" maxlength="80" onkeyup="validaCorreosIguales('correo1','correo2','itemSubmit');" required></td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2"><input type="email" id="correo2" class="form-input-text" placeholder="<spring:message code="label.cemail" />" minlength="7" maxlength="80" onkeyup="validaCorreosIguales('correo1','correo2','itemSubmit');" required></td>
						</tr>
						<tr>
							<td class="form-espacio">
								<input type="password" id="clave1" class="form-input-text" placeholder="<spring:message code="label.clave" />" minlength="5" maxlength="20" onkeyup="validaClavesIguales('clave1','clave2','claveHash','itemSubmit');" required>
								<input type="hidden" name="clave" id="claveHash">
							</td>
						</tr>
						<tr>
							<td class="form-espacio"><input type="password" id="clave2" class="form-input-text" placeholder="<spring:message code="label.cclave" />" minlength="5" maxlength="20" onkeyup="validaClavesIguales('clave1','clave2','claveHash','itemSubmit');" required></td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2">
								<select class="form-input-lista" name="pais" required="required">
									<option value=""><spring:message code="label.pais" /></option>
									<c:forEach items="${paises}" var="pais">
										<option value="${pais.id}">${pais.nombre}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2"><h3><spring:message code="label.fnacimiento" /></h3></td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2">
								<select class="form-input-lista" name="anio" id="anio" onchange="generarDias('anio','mes','dia');" required>
									<option value=""><spring:message code="label.anio" /></option>
									<c:forEach items="${anios}" var="anio">
										<option value="${anio}">${anio}</option>
									</c:forEach>
								</select>
								<select class="form-input-lista" name="mes" id="mes" onchange="generarDias('anio','mes','dia');" required>
									<option value=""><spring:message code="label.mes" /></option>
									<option value="01"><spring:message code="label.enero" /></option>
									<option value="02"><spring:message code="label.febrero" /></option>
									<option value="03"><spring:message code="label.marzo" /></option>
									<option value="04"><spring:message code="label.abril" /></option>
									<option value="05"><spring:message code="label.mayo" /></option>
									<option value="06"><spring:message code="label.junio" /></option>
									<option value="07"><spring:message code="label.julio" /></option>
									<option value="08"><spring:message code="label.agosto" /></option>
									<option value="09"><spring:message code="label.septiembre" /></option>
									<option value="10"><spring:message code="label.octubre" /></option>
									<option value="11"><spring:message code="label.noviembre" /></option>
									<option value="12"><spring:message code="label.diciembre" /></option>
								</select>
								<select class="form-input-lista" name="dia" id="dia" required>
									<option value=""><spring:message code="label.dia" /></option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="form-espacio">
								<input type="radio" name="sexo" value="M" required> <spring:message code="label.mujer" />
								<input type="radio" name="sexo" value="H" required> <spring:message code="label.hombre" />
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td class="form-espacio" colspan="2"><input type="submit" class="boton-formulario centrar" id="itemSubmit" value="<spring:message code="label.registrarse" />"></td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>
	</div>
</body>
</html>