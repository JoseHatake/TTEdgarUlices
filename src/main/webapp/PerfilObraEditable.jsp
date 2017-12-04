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
			<form action="EditarObra" enctype="multipart/form-data" class="centrar" method="POST">
				<input type="hidden" name="idObraEditar" value="${detallesObra.idObra}">
				<div class="fondoFormato">
					<div style="height: 350px">
						<div class="izquierda" id="obra-portada">
							<c:choose>
								<c:when test="${detallesObra.portada != null}">
									<img id="portada" alt="default" src="data:image/jpeg;base64,${detallesObra.portada}">
								</c:when>
								<c:otherwise>
									<img src="img/pd.png" id="portada" alt="default">
								</c:otherwise>
							</c:choose>
							<input type="file" accept="image/*" id="origenFoto" name="foto" onchange="cambiaFoto('origenFoto','portada');">
						</div>
						<div class="derecha" id="nueva-obra">
							<ul>
								<li class="form-espacio"><input type="text" name="titulo" id="titulo" value="${obra.nombre}" class="form-input-text" placeholder="<spring:message code="label.titulo" />" minlength="1" maxlength="50" required></li>
								<li class="form-espacio"><select class="form-input-lista" name="idioma" id="idioma" required>
										<option value=""><spring:message code="label.idioma" /></option>
										<c:choose>
											<c:when test="${obra.idiomaObj.id == 1}">
												<option value="1" selected><spring:message code="label.español" /></option>
												<option value="2"><spring:message code="label.ingles" /></option>
											</c:when>
											<c:otherwise>
												<option value="1"><spring:message code="label.español" /></option>
												<option value="2" selected><spring:message code="label.ingles" /></option>
											</c:otherwise>
										</c:choose>
								</select></li>
								<li class="form-espacio"><h3><spring:message code="label.genero" /></h3></li>
								<li>
									<table style="width: 100%" class="generos-form">
										<c:set value="1" var="contador"></c:set>
										<c:forEach begin="1" end="4" var="fila">
											<tr>
												<c:forEach begin="${contador}" end="${contador+2}" var="columna">
													<c:set value="true" var="flag"></c:set>
													<c:forEach items="${generos}" var="genero">
														<c:choose>
															<c:when test="${genero.generosObj.id == columna}">
																<td><input type="checkbox" class="checador" name="${columna}" value="${columna}" onclick="checarCheckbox('checador');" checked required> <spring:message code="label.genero${columna}" /><br></td>
																<c:set value="false" var="flag"></c:set>
															</c:when>
														</c:choose>
													</c:forEach>
													<c:if test="${flag}">
														<td><input type="checkbox" class="checador" name="${columna}" value="${columna}" onclick="checarCheckbox('checador');"> <spring:message code="label.genero${columna}" /><br></td>
													</c:if>
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
						<textarea name="sinopsis" id="sinopsis" class="form-input-text" cols="50" rows="5" maxlength="250"><c:out value="${obra.sinopsis}"></c:out></textarea>
					</div>
					<table style="margin-top: 20px;">
						<tbody>
								<tr>
									<td style="padding-right: 10px;"><a href="BuscarInformacionFormularios?metodoDeBusqueda=8&esAjax=false&direccion=PerfilObra.jsp&idObra=${detallesObra.idObra}"><input type="button" class="boton-formulario centrar" value="<spring:message code="label.cancelar" />"></a></td>
									<td style="padding-left: 10px;"><input type="submit" class="boton-formulario centrar" id="itemSubmit" value="<spring:message code="label.guardar" />"></td>
								</tr>
						</tbody>
					</table>
				</div>
				</form>
			</div>
		</div>
	
</body>
</html>