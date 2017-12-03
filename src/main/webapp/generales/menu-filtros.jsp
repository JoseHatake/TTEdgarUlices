<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="FiltradoLibros" class="opciones-menu">
	<nav>
		<ul>
			<li>
				<div class="opciones-menu-altura padding-menu">
					<div class="texto-centro opciones-menu-altura izquierda">
						<input type="text" id="input-buscar-filtrado" placeholder="<spring:message code="label.buscar" />" maxlength="100">
					</div>
				</div>
			</li>
			<li>
				<div class="opciones-menu-altura padding-menu" onclick="switchEstado('idioma')">
					<div class="texto-centro opciones-menu-altura izquierda">
						<p><spring:message code="label.idioma" /></p>
					</div>
				</div>
				<ul>
					<li class="subopcion-menu-margenes oculto" id="idioma">
						<select name="idioma">
							<option value=""><spring:message code="label.selidioma" /></option>
							<option value="es"><spring:message code="label.español" /></option>
							<option value="en"><spring:message code="label.ingles" /></option>
						</select>
					</li>
				</ul>
			</li>
			<li>
				<div class="opciones-menu-altura padding-menu"  onclick="switchEstado('genero')">
					<div class="texto-centro opciones-menu-altura izquierda">
						<p><spring:message code="label.genero" /></p>
					</div>
				</div>
				<ul>
					<li class="subopcion-menu-margenes oculto" id="genero">
						<select name="genero">
							<option value=""><spring:message code="label.selgenero" /></option>
							<c:forEach var="id" begin="1" end="12">
								<option value="${id}"><spring:message code="label.genero${id}"/></option>
							</c:forEach>
						</select>
					</li>
				</ul>
			</li>
			<li>
				<div class="opciones-menu-altura padding-menu" onclick="switchEstado('ranking')">
					<div class="texto-centro opciones-menu-altura izquierda">
						<p><spring:message code="label.rankinga" /></p>
					</div>
				</div>
				<ul>
					<li class="subopcion-menu-margenes oculto" id="ranking">
						<table>
							<tbody>
								<tr>
									<c:forEach var="numeroEstrellaRanking" begin="1" end="5">
										<td><span class="icon-star-empty estrella cursor-pointer centrar" id="estrellaRankingFiltro${numeroEstrellaRanking}" onclick="styleStarts('estrellaRankingFiltro',${numeroEstrellaRanking},'numeroEstrellasRankingFiltro');"></span></td>
									</c:forEach>
								</tr>
							</tbody>
						</table> <input type="hidden" id="numeroEstrellasRankingFiltro" name="estrellasRankingFiltro" value="0">
					</li>
				</ul>
			</li>
			<li>
				<div class="opciones-menu-altura padding-menu" onclick="switchEstado('capitulos')">
					<div class="texto-centro opciones-menu-altura izquierda">
						<p><spring:message code="label.numcaps" /></p>
					</div>
				</div>
				<ul>
					<li class="subopcion-menu-margenes oculto" id="capitulos">
						<input type="text" name="capitulos" placeholder="<spring:message code="label.numero" />">	
					</li>
				</ul>
			</li>
			<li>
				<div class="opciones-menu-altura padding-menu" onclick="switchEstado('popularidad')">
					<div class="texto-centro opciones-menu-altura izquierda">
						<p><spring:message code="label.popularidad" /></p>
					</div>
				</div>
				<ul>
					<li class="subopcion-menu-margenes oculto" id="popularidad">
						<table>
							<tbody>
								<tr>
									<c:forEach var="numeroEstrellaPopularidad" begin="1" end="5">
										<td><span class="icon-star-empty estrella cursor-pointer centrar" id="popularidadEstrella${numeroEstrellaPopularidad}" onclick="styleStarts('popularidadEstrella',${numeroEstrellaPopularidad},'popularidad');"></span></td>
									</c:forEach>
								</tr>
							</tbody>
						</table> <input type="hidden" id="popularidad" name="popularidad" value="0">
					</li>
				</ul>
			</li>
		</ul>
	</nav>
	<input type="submit" class="vinculos boton-formulario centrar" value="<spring:message code="label.buscar" />">
</form>