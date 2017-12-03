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
										<option value="1"><spring:message code="label.español" /></option>
										<option value="2"><spring:message code="label.ingles" /></option>
								</select></li>
								<li class="form-espacio"><h3><spring:message code="label.genero" /></h3></li>
								<li>
									<table style="width: 100%" class="generos-form">
										<tr>
											<td><input type="checkbox" class="checador" name="1" value="1" onclick="checarCheckbox('checador');" required>
												<spring:message code="label.genero1" /><br></td>
											<td><input type="checkbox" class="checador" name="2" value="2" onclick="checarCheckbox('checador');" required>
												<spring:message code="label.genero2" /><br></td>
											<td><input type="checkbox" class="checador" name="3" value="3" onclick="checarCheckbox('checador');" required>
												<spring:message code="label.genero3" /><br></td>
										</tr>

										<tr>
											<td><input type="checkbox" class="checador" name="4" value="4" onclick="checarCheckbox('checador');" required>
												<spring:message code="label.genero4" /><br></td>
											<td><input type="checkbox" class="checador" name="5"
												value="5" required> <spring:message code="label.genero5" /><br></td>
											<td><input type="checkbox" class="checador" name="6" value="6" onclick="checarCheckbox('checador');" required>
												<spring:message code="label.genero6" /><br></td>
										</tr>

										<tr>
											<td><input type="checkbox" class="checador" name="7" value="7" onclick="checarCheckbox('checador');" required>
												<spring:message code="label.genero7" /><br></td>
											<td><input type="checkbox" class="checador" name="8" value="8" onclick="checarCheckbox('checador');" required>
												<spring:message code="label.genero8" /><br></td>
											<td><input type="checkbox" class="checador" name="9" value="9" onclick="checarCheckbox('checador');" required>
												<spring:message code="label.genero9" /><br></td>
										</tr>

										<tr>
											<td><input type="checkbox" class="checador" name="10" value="10" onclick="checarCheckbox('checador');" required>
												<spring:message code="label.genero10" /><br></td>
											<td><input type="checkbox" class="checador" name="11" value="11" onclick="checarCheckbox('checador');" required>
												<spring:message code="label.genero11" /><br></td>
											<td><input type="checkbox" class="checador" name="12" value="12" onclick="checarCheckbox('checador');" required>
												<spring:message code="label.genero12" /><br></td>
										</tr>
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