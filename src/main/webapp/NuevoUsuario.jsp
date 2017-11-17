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
	<script type="text/javascript" src="js/codeHash.js"></script>
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
							<th><h1>Crear cuenta</h1></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="form-espacio"><input type="text" name="usuario" id="usuario" class="form-input-text" placeholder="Usuario" minlength="5" maxlength="20" onkeyup="usuarioDisponible('usuario','itemSubmit');" required></td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2"><input type="text" name="nombre" class="form-input-text" placeholder="Nombre" maxlength="45" required></td>
						</tr>
						<tr>
							<td class="form-espacio"><input type="text" name="apellidoPaterno" class="form-input-text" placeholder="Apelido Paterno" maxlength="30" required></td>
							<td class="form-espacio"><input type="text" name="apellidoMaterno" class="form-input-text" placeholder="Apelido Materno" maxlength="30" required></td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2"><input type="email" name="correo" id="correo1" class="form-input-text" placeholder="Correo electrónico" minlength="7" maxlength="80" onkeyup="validaCorreosIguales('correo1','correo2','itemSubmit');" required></td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2"><input type="email" id="correo2" class="form-input-text" placeholder="Confirmar correo" minlength="7" maxlength="80" onkeyup="validaCorreosIguales('correo1','correo2','itemSubmit');" required></td>
						</tr>
						<tr>
							<td class="form-espacio">
								<input type="password" id="clave1" class="form-input-text" placeholder="Contraseña" minlength="5" maxlength="20" onkeyup="validaClavesIguales('clave1','clave2','claveHash','itemSubmit');" required>
								<input type="hidden" name="clave" id="claveHash">
							</td>
						</tr>
						<tr>
							<td class="form-espacio"><input type="password" id="clave2" class="form-input-text" placeholder="Confirmar contraseña" minlength="5" maxlength="20" onkeyup="validaClavesIguales('clave1','clave2','claveHash','itemSubmit');" required></td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2">
								<select class="form-input-lista" name="pais" required="required">
									<option value="">Pais</option>
									<c:forEach items="${paises}" var="pais">
										<option value="${pais.id}">${pais.nombre}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2"><h3>Fecha de nacimiento</h3></td>
						</tr>
						<tr>
							<td class="form-espacio" colspan="2">
								<select class="form-input-lista" name="anio" id="anio" onchange="generarDias('anio','mes','dia');" required>
									<option value="">Año</option>
									<c:forEach items="${anios}" var="anio">
										<option value="${anio}">${anio}</option>
									</c:forEach>
								</select>
								<select class="form-input-lista" name="mes" id="mes" onchange="generarDias('anio','mes','dia');" required>
									<option value="">Mes</option>
									<option value="01">Enero</option>
									<option value="02">Febrero</option>
									<option value="03">Marzo</option>
									<option value="04">Abril</option>
									<option value="05">Mayo</option>
									<option value="06">Junio</option>
									<option value="07">Julio</option>
									<option value="08">Agosto</option>
									<option value="09">Septiembre</option>
									<option value="10">Octubre</option>
									<option value="11">Noviembre</option>
									<option value="12">Diciembre</option>
								</select>
								<select class="form-input-lista" name="dia" id="dia" required>
									<option value="">Día</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="form-espacio">
								<input type="radio" name="sexo" value="M" required> Mujer
								<input type="radio" name="sexo" value="H" required> Hombre
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td class="form-espacio" colspan="2"><input type="submit" class="boton-formulario centrar" id="itemSubmit" value="Registrar"></td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>
	</div>
</body>
</html>