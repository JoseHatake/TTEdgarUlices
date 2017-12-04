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
			<form action="HacerDenuncia" class="centrar">
				<input type="hidden" name="idLibro" id="idLibro" value="${param.idLibro}">
				<table class="form-config">
					<thead>
						<tr>
							<th><h2><spring:message code="label.reportarobra" /></h2></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<select class="form-input-lista" name="razon" id="razon" required>
											<option value=""><spring:message code="label.razondenuncia" /></option>
											<c:forEach var="id" begin="1" end="2">
												<option value="${id}"><spring:message code="label.razon${id}" /></option>
											</c:forEach>										
								</select>
							</td>	
						</tr>						
						<tr>
							<td>
								<h3><spring:message code="label.descripcion" /></h3>
								<textarea name="descripcion" id="descripcion" placeholder="<spring:message code="label.mensajedenuncia" />" class="form-input-text" cols="50" rows="25" required></textarea>
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td style="padding-left: 30%; padding-top: 20px;">
								<a href="index.jsp"><input type="button" class="boton-formulario" value="<spring:message code="label.cancelar" />"></a>
								<input type="submit" class="boton-formulario" id="itemSubmit" value="<spring:message code="label.reportar" />">
							</td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>
	</div>
</body>
</html>