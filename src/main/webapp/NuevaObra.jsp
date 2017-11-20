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
	<form action="CrearObra" class="centrar" method="POST">
		<div class="menu-filtros" id="menu-lista-filtros"></div>
		<div class="contenedor">
			<div class="contenido">
				<div class="fondoFormato">
					<div style="height: 350px">
						<div class="izquierda" id="obra-portada">
							<img src="img/pd.png" alt="default">
						</div>
						<div class="derecha" id="nueva-obra">
							<ul>
								<li class="form-espacio"><input type="text" name="titulo"
									id="titulo" class="form-input-text" placeholder="Titulo"
									minlength="5" maxlength="20" required></li>

								<li class="form-espacio"><select class="form-input-lista"
									name="idioma" id="idioma" required>
										<option value="">Idioma</option>
										<option value="1">Español</option>
										<option value="2">Inglés</option>
								</select></li>
								<li class="form-espacio"><h3>Género:</h3></li>
								<li>
									<table style="width: 100%" class="generos-form">
										<tr>
											<td><input type="checkbox" name="comedia" value="1">
												Comedia<br></td>
											<td><input type="checkbox" name="cuento" value="2">
												Cuento<br></td>
											<td><input type="checkbox" name="drama" value="3">
												Drama<br></td>
										</tr>

										<tr>
											<td><input type="checkbox" name="fantasia" value="4">
												Fantasia<br></td>
											<td><input type="checkbox" name="ciencia-ficcion"
												value="5"> Ciencia Ficción<br></td>
											<td><input type="checkbox" name="historico" value="6">
												Histórico<br></td>
										</tr>

										<tr>
											<td><input type="checkbox" name="misterio" value="7">
												Misterio<br></td>
											<td><input type="checkbox" name="suspenso" value="8">
												Suspenso<br></td>
											<td><input type="checkbox" name="terror" value="9">
												Terror<br></td>
										</tr>

										<tr>
											<td><input type="checkbox" name="tragedia" value="10">
												Tragedia<br></td>
											<td><input type="checkbox" name="romance" value="11">
												Romance<br></td>
											<td><input type="checkbox" name="poesia" value="12">
												Poesía<br></td>
										</tr>
									</table>
								</li>


							</ul>
						</div>
					</div>
					<div class="contenido45 formato-texto">
						<h3>Sinopsis:</h3>
						<input type="textarea" name="sinopsis" id="sinopsis" class="form-input-text" placeholder="Sinopsis" cols="50" rows="10" wrap="hard">
					</div>
					<div class="contenedor-boton">
						<input type="submit" class="boton-formulario centrar" id="itemSubmit" value="Crear">
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>