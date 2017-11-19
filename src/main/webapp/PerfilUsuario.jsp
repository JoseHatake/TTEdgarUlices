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
				<div style="height: 250px">
					<div class="izquierda" id="perfil-imagen-edit">
						<ul>
							<li><h4>Seguidores</h4></li>
							<li><img src="img/default.jpg" class="img-circulo" alt="default"></li>
							<li>Estrellas</li>
						</ul>
					</div>
					<div class="derecha" id="perfil-info-edit">
						<ul>
							<li>Seudónimo</li>
							<li>Contacto:</li>
							<li>
								<ul>
									<li>Correo</li>
									<li>Redes sociales</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				<div class="contenido75 formato-texto">
					<h3>Descripción:</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
				</div>
				<div class="contenedor-libros"></div>
			</div>
		</div>
	</div>
</body>
</html>