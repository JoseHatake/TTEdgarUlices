<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${usuario.id == null && usuario.nick == null}">
    		<c:set var="error" value="oculto"></c:set>
</c:if>
<div id="iniciar-sesion" class="menuSlide menu-perfil ${error}">
    <form action="Acciones?accion=2&direccion=index.jsp" method="POST">
        <table class="contenedor-menu-perfil">
            <tbody>
                <tr>
                    <td align="left"><label for="usuario" style="margin-right: 10px;"><spring:message code="label.usuario" /></label></td>
                    <td><input type="text" name="usuario" placeholder="<spring:message code="label.usuario" />" value="${usuario.nick}" maxlength="20" required></td>
                </tr>
                <tr>
                    <td align="left"><label for="clave" style="margin-right: 10px;"><spring:message code="label.clave" /></label></td>
                    <td>
                    		<input type="password" id="clavePlano" placeholder="·····" maxlength="20" onkeyup="codificarClave('clavePlano','claveLog');" required>
                    		<input type="hidden" name="clave" id="claveLog">
                    	</td>
                </tr>
            </tbody>
        </table>
        <input type="submit" class="boton-formulario" value="<spring:message code="label.isesion" />">
    </form>
    <c:if test="${usuario.id == null && usuario.nick != null}">
    		<c:choose>
    			<c:when test="${usuario.estadoCuenta == 0}">
    				<p><spring:message code="label.cinactiva" /></p>
    			</c:when>
    			<c:otherwise>
    				<p><spring:message code="label.uinvalido" /></p>
    			</c:otherwise>
    		</c:choose>
    </c:if>
    <div class="vinculos">
        <a href="BuscarInformacionFormularios?metodoDeBusqueda=3&esAjax=false&direccion=NuevoUsuario.jsp"><spring:message code="label.registrarse" /></a>
        <br>
        <a href="RecuperarClave.jsp"><spring:message code="label.olvidocon" /></a>
    </div>
</div>
<div id="usuario" class="menuSlide menu-perfil oculto">
    <nav class="contenedor-menu-perfil">
        <div class="opciones-menu">
            <ul>
                <a href="BuscarInformacionFormularios?metodoDeBusqueda=4&esAjax=false&direccion=PerfilUsuario.jsp&nickName=${usuario.nick}"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p><spring:message code="label.perfil" /></p></div></li></a>
                <a href="NuevaObra.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p><spring:message code="label.nobra" /></p></div></li></a>
                <a href="CreaCapitulo.jsp?idObra=37"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p><spring:message code="label.ncapitulo" /></p></div></li></a>
                <a href="CambiarClave.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p><spring:message code="label.cambiarcon" /></p></div></li></a>
                <a href="Acciones?accion=3&direccion=index.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p><spring:message code="label.cerrarsesion" /></p></div></li></a>
            </ul>
        </div>
        <hr>
        <h3><spring:message code="label.aseguidos" /></h3>
        <div class="opciones-menu">
            <ul>
            		<c:forEach items="${contactos}" var="contacto">
            			<c:choose>
            				<c:when test="${contacto.imgPerfil == null}">
            					<a href="BuscarInformacionFormularios?metodoDeBusqueda=4&esAjax=false&direccion=PerfilUsuario.jsp&nickName=${contacto.nickName}"><li class="padding-menu"><div class="img-perfil-icono izquierda"><img src="img/default.jpg" alt="usuario" class="img-circulo"></div><div class="texto-centro opciones-menu-altura izquierda"><p><c:out value="${contacto.nickName}"></c:out></p></div></li></a>
            				</c:when>
            				<c:otherwise>
            					<a href="BuscarInformacionFormularios?metodoDeBusqueda=4&esAjax=false&direccion=PerfilUsuario.jsp&nickName=${contacto.nickName}"><li class="padding-menu"><div class="img-perfil-icono izquierda"><img src="data:image/jpeg;base64,${contacto.imgPerfil}" alt="usuario" class="img-circulo"></div><div class="texto-centro opciones-menu-altura izquierda"><p><c:out value="${contacto.nickName}"></c:out></p></div></li></a>
            				</c:otherwise>
            			</c:choose>
            		</c:forEach>
            	</ul>
        </div>
    </nav>
    <div class="vinculos">
        <a href="BuscarInformacionFormularios?metodoDeBusqueda=6&esAjax=false&direccion=AutoresSeguidos.jsp"><spring:message code="label.vertodos" /></a>
    </div>
</div>
<div id="administrador" class="menuSlide menu-perfil oculto">
    <nav class="contenedor-menu-perfil">
        <div class="opciones-menu">
            <ul>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p><spring:message code="label.perfil" /></p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p><spring:message code="label.verreportes" /></p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p><spring:message code="label.rpendientes" /></p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p><spring:message code="label.obloqueadas" /></p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p><spring:message code="label.ubloqueados" /></p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p><spring:message code="label.cambiarcon" /></p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p><spring:message code="label.cerrarsesion" /></p></div></li></a>
            </ul>
        </div>
    </nav>
</div>