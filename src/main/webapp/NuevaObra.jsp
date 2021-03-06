<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
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
			<form action="CrearObra" enctype="multipart/form-data" class="centrar" method="POST">
				<div class="fondoFormato">
					<div style="height: 350px">
						<div class="izquierda" id="obra-portada">
							<img src="img/pd.png" id="portada" alt="default">
							<input type="file" accept="image/*" id="origenFoto" name="foto" onchange="cambiaFoto('origenFoto','portada');">
						</div>
						<div class="derecha" id="nueva-obra">
							<ul>
								<li class="form-espacio"><input type="text" name="titulo"
									id="titulo" class="form-input-text" placeholder="<spring:message code="label.titulo" />"
									minlength="1" maxlength="50" required></li>

								<li class="form-espacio"><select class="form-input-lista"
									name="idioma" id="idioma" required>
										<option value=""><spring:message code="label.idioma" /></option>
										<option value="1"><spring:message code="label.espa�ol" /></option>
										<option value="2"><spring:message code="label.ingles" /></option>
								</select></li>
								<li class="form-espacio"><h3><spring:message code="label.genero" /></h3></li>
								<li>
									<table style="width: 100%" class="generos-form">
										<c:set value="1" var="contador"></c:set>
										<c:forEach begin="1" end="4" var="fila">
											<tr>
												<c:forEach begin="${contador}" end="${contador+2}" var="columna">
													<td><input type="checkbox" class="checador" name="${columna}" value="${columna}" onclick="checarCheckbox('checador');" required> <spring:message code="label.genero${columna}" /><br></td>
												</c:forEach>
												<c:set value="${contador+3}" var="contador"></c:set>
											</tr>
										</c:forEach>
									</table>
								</li>
							</ul>
						</div>
					</div>
					<div class="contenido45 formato-texto">
						<h3><spring:message code="label.sinopsis" /></h3>
						<textarea name="sinopsis" id="sinopsis" class="form-input-text" cols="50" rows="5" wrap="hard" maxlength="250"></textarea>
					</div>
					<div class="contenedor-boton">
						<input type="submit" class="boton-formulario centrar" id="itemSubmit" value="<spring:message code="label.crearo" />">
					</div>
				</div>
				</form>
			</div>
		</div>
	
</body>
</html>