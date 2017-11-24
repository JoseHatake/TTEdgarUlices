<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="FiltradoLibros" class="opciones-menu">
	<nav>
		<ul>
			<li>
				<div class="opciones-menu-altura padding-menu">
					<div class="texto-centro opciones-menu-altura izquierda">
						<input type="text" id="input-buscar-filtrado" placeholder="Buscar" maxlength="100">
					</div>
				</div>
			</li>
			<li>
				<div class="opciones-menu-altura padding-menu" onclick="switchEstado('idioma')">
					<div class="texto-centro opciones-menu-altura izquierda">
						<p>Idioma</p>
					</div>
				</div>
				<ul>
					<li class="subopcion-menu-margenes oculto" id="idioma">
						<select name="idioma">
							<option value="">Selecciona el idioma</option>
							<option value="es">Espa�ol</option>
							<option value="en">Ingl�s</option>
						</select>
					</li>
				</ul>
			</li>
			<li>
				<div class="opciones-menu-altura padding-menu"  onclick="switchEstado('genero')">
					<div class="texto-centro opciones-menu-altura izquierda">
						<p>G�nero</p>
					</div>
				</div>
				<ul>
					<li class="subopcion-menu-margenes oculto" id="genero">
						<select name="genero">
							<option value="">Selecciona el g�nero</option>
							<option value="1">Terror</option>
							<option value="2">Dr�ma</option>
							<option value="3">Novela</option>
						</select>
					</li>
				</ul>
			</li>
			<li>
				<div class="opciones-menu-altura padding-menu" onclick="switchEstado('ranking')">
					<div class="texto-centro opciones-menu-altura izquierda">
						<p>Ranking de autor</p>
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
				<div class="opciones-menu-altura padding-menu" onclick="switchEstado('fecha')">
					<div class="texto-centro opciones-menu-altura izquierda">
						<p>Fecha de publicaci�n</p>
					</div>
				</div>
				<ul>
					<li class="subopcion-menu-margenes oculto" id="fecha">
						<input type="date" name="fechaPublicacion" placeholder="2000-01-01">	
					</li>
				</ul>
			</li>
			<li>
				<div class="opciones-menu-altura padding-menu" onclick="switchEstado('capitulos')">
					<div class="texto-centro opciones-menu-altura izquierda">
						<p>N�mero de cap�tulos</p>
					</div>
				</div>
				<ul>
					<li class="subopcion-menu-margenes oculto" id="capitulos">
						<input type="text" name="capitulos" placeholder="Número">	
					</li>
				</ul>
			</li>
			<li>
				<div class="opciones-menu-altura padding-menu" onclick="switchEstado('popularidad')">
					<div class="texto-centro opciones-menu-altura izquierda">
						<p>Popularidad</p>
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
	<input type="submit" class="vinculos boton-formulario centrar" value="Buscar">
</form>