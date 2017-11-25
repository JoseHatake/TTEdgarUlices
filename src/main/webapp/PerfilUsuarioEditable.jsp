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
				<form action="EditaPerfil" method="POST">
					<div style="height: 250px">
						<div class="izquierda" id="perfil-imagen-edit">
							<img src="img/default.jpg" id="foto" class="img-circulo" alt="default">
							<input type="file" accept="image/*" id="origenFoto" name="foto" onchange="cambiaFoto('origenFoto','foto');">
						</div>
						<div class="derecha" id="perfil-info-edit">
						</div>
					</div>
					<div class="contenido75 formato-texto">
						<h3>Descripción:</h3>
						<p><c:out value="${usuario.perfilObj.descripcion}"></c:out></p>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>