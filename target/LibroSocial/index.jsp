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
	<!-- JavaScript -->
	<title>SocialWriters</title>
</head>
<body>
	<header>
		<div id="cabecera"></div>
	</header>
	<div class="contenedor">
		<div class="menu-filtros izquierda">
			<form action="FiltradoLibros" class="opciones-menu">
				<nav>
					<ul>
						<li>
							<div class="texto-centro opciones-menu-altura izquierda">
								<p>Idioma</p>
							</div>
							<ul>
								<li class="subopcion-menu-margenes">
									<select name="idioma">
										<option value="">Selecciona el idioma</option>
										<option value="es">Español</option>
										<option value="en">Inglés</option>
									</select>
								</li>
							</ul>
						</li>
						<li>
							<div class="texto-centro opciones-menu-altura izquierda">
								<p>Género</p>
							</div>
							<ul>
								<li class="subopcion-menu-margenes">
									<select name="genero">
										<option value="">Selecciona el género</option>
										<option value="1">Terror</option>
										<option value="2">Dráma</option>
										<option value="3">Novela</option>
									</select>
								</li>
							</ul>
						</li>
						<li>
							<div class="texto-centro opciones-menu-altura izquierda">
								<p>Ranking de autor</p>
							</div>
							<ul>
								<li class="subopcion-menu-margenes">
									<input type="range" name="points" min="0" max="5">
								</li>
							</ul>
						</li>
						<li>
							<div class="texto-centro opciones-menu-altura izquierda">
								<p>Fecha de publicación</p>
							</div>
							<li class="subopcion-menu-margenes">
								<input type="date" name="fechaPublicacion">	
							</li>
						</li>
						<li>
							<div class="texto-centro opciones-menu-altura izquierda">
								<p>Número de capítulos</p>
							</div>
						</li>
						<li>
							<div class="texto-centro opciones-menu-altura izquierda">
								<p>Popularidad</p>
							</div>
						</li>
					</ul>
				</nav>
				<input type="submit" class="vinculos boton-formulario centrar" value="Filtrar">
			</form>
		</div>
		<div class="contenido derecha"></div>
	</div>
</body>
</html>