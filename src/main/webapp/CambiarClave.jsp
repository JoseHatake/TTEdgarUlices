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
			<form action="Acciones?accion=5&direccion=MensajeUsuarioRegistrado.jsp" class="centrar" method="POST">
				<table class="form-config">
					<thead>
						<tr>
							<th><h2><spring:message code="label.cambiarcon" /></h2></th>
						</tr>
					</thead>
					<tbody>
						
						<tr>
							<td class="form-espacio" colspan="2"><input type="password" id ="clave0" class="form-input-text" placeholder="<spring:message code="label.claveactual" />" maxlength="45" onkeyup="codificarClave('clave0','HashActual');" required>
							<input type="hidden" name="claveActual" id="HashActual">
							</td>
						</tr>
												
						<tr>
							<td class="form-espacio">
								<input type="password" id="clave1" class="form-input-text" placeholder="<spring:message code="label.nclave" />" minlength="5" maxlength="20" onkeyup="validaClavesIguales('clave1','clave2','claveHash','itemSubmit');" required>
								<input type="hidden" name="claveNueva" id="claveHash">
							</td>
						</tr>
						<tr>
							<td class="form-espacio"><input type="password" id="clave2" class="form-input-text" placeholder="<spring:message code="label.cnclave" />" minlength="5" maxlength="20" onkeyup="validaClavesIguales('clave1','clave2','claveHash','itemSubmit');" required></td>
						</tr>
						
					</tbody>
					<tfoot>
						<tr>
							<td class="form-espacio" colspan="2"><input type="submit" class="boton-formulario centrar" id="itemSubmit" value="<spring:message code="label.cambiarcon" />"></td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>
	</div>
</body>
</html>