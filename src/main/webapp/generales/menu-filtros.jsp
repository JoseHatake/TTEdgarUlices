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
							<option value="1"><spring:message code="label.comedia" /></option>
							<option value="2"><spring:message code="label.cuento" /></option>
							<option value="3"><spring:message code="label.drama" /></option>
							<option value="4"><spring:message code="label.fantasia" /></option>
							<option value="5"><spring:message code="label.sci-fi" /></option>
							<option value="6"><spring:message code="label.historico" /></option>
							<option value="7"><spring:message code="label.misterio" /></option>
							<option value="8"><spring:message code="label.suspenso" /></option>
							<option value="9"><spring:message code="label.terror" /></option>
							<option value="10"><spring:message code="label.tragedia" /></option>
							<option value="11"><spring:message code="label.romance" /></option>
							<option value="12"><spring:message code="label.poesia" /></option>
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