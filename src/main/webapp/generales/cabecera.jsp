<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table id="barraArriba">
	<tbody>
		<tr>
			<th align="center"><span class="icon-menu centrar" id="menu-filtros"></span></th>
			<th align="center"><a href="index.jsp"><img id="logotipo" src="img/logo.png" alt="logotipo"></a></th>
			<th align="center">
				<form id="formulario-busqueda" accept="" method="POST">
					<input type="text" class="izquierda" id="input-buscar" placeholder="Buscar" maxlength="100">
					<button class="derecha" id="button-buscar" onclick="id('formulario-busqueda').submit();">
						<span class="icon-search"></span>
					</button>
				</form>
			</th>
			<th align="right">
				<table class="derecha">
					<tbody>
						<tr>
							<th><span class="icon-bell notificacion centrar"></span></th>
							<th>
							<c:if test="${usuario.id == null && usuario.nick != null}">
							    		<c:set var="styleOpen" value="openMenuPerfil"></c:set>
							</c:if>
								<div class="perfil perfil-altura derecha ${styleOpen}" id="boton-perfil">
									<div id="img-perfil">
										<img src="img/default.jpg" class="img-circulo" alt="default">
									</div>
									<div id="nombre-perfil">
										<div class="texto-centro perfil-altura"><p>${nombre}</p></div>
									</div>
								</div>
								<div id="${perfil}"></div>
							</th>
						</tr>
					</tbody>
				</table>
			</th>
		</tr>
	</tbody>
</table>
<script type="text/javascript" src="js/carga-menu-perfil.js"></script>