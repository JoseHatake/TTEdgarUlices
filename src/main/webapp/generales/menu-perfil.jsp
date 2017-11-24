<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${usuario.id == null && usuario.nick == null}">
    		<c:set var="error" value="oculto"></c:set>
</c:if>
<div id="iniciar-sesion" class="menuSlide menu-perfil ${error}">
    <form action="Acciones?accion=2&direccion=index.jsp" method="POST">
        <table class="contenedor-menu-perfil">
            <tbody>
                <tr>
                    <td align="left"><label for="usuario" style="margin-right: 10px;">Usuario</label></td>
                    <td><input type="text" name="usuario" placeholder="Usuario" value="${usuario.nick}" maxlength="20" required></td>
                </tr>
                <tr>
                    <td align="left"><label for="clave" style="margin-right: 10px;">Contraseña</label></td>
                    <td>
                    		<input type="password" id="clavePlano" placeholder="·····" maxlength="20" onkeyup="codificarClave('clavePlano','claveLog');" required>
                    		<input type="hidden" name="clave" id="claveLog">
                    	</td>
                </tr>
            </tbody>
        </table>
        <input type="submit" class="boton-formulario" value="Iniciar">
    </form>
    <c:if test="${usuario.id == null && usuario.nick != null}">
    		<c:choose>
    			<c:when test="${usuario.estadoCuenta == 0}">
    				<p>Cuenta no activada</p>
    			</c:when>
    			<c:otherwise>
    				<p>Usuario inválido</p>
    			</c:otherwise>
    		</c:choose>
    </c:if>
    <div class="vinculos">
        <a href="BuscarInformacionFormularios?metodoDeBusqueda=3&esAjax=false&direccion=NuevoUsuario.jsp">Registrarse</a>
        <br>
        <a href="RecuperarClave.jsp">Olvidó su contraseña?</a>
    </div>
</div>
<div id="usuario" class="menuSlide menu-perfil oculto">
    <nav class="contenedor-menu-perfil">
        <div class="opciones-menu">
            <ul>
                <a href="BuscarInformacionFormularios?metodoDeBusqueda=4&esAjax=false&direccion=PerfilUsuario.jsp&nickName=${usuario.nick}"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p>Perfil</p></div></li></a>
                <a href="NuevaObra.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p>+ Obra</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p>+ Capítulo</p></div></li></a>
                <a href="CambiarClave.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p>Cambiar contraseña</p></div></li></a>
                <a href="Acciones?accion=3&direccion=index.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p>Cerrar sesión</p></div></li></a>
            </ul>
        </div>
        <hr>
        <h3>Autores seguidos</h3>
        <div class="opciones-menu">
            <ul>
                <a href="index.jsp"><li class="padding-menu"><div class="img-perfil-icono izquierda"><img src="img/default.jpg" alt="usuario" class="img-circulo"></div><div class="texto-centro opciones-menu-altura izquierda"><p>Nombre de usuario</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="img-perfil-icono izquierda"><img src="img/default.jpg" alt="usuario" class="img-circulo"></div><div class="texto-centro opciones-menu-altura izquierda"><p>Nombre de usuario</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="img-perfil-icono izquierda"><img src="img/default.jpg" alt="usuario" class="img-circulo"></div><div class="texto-centro opciones-menu-altura izquierda"><p>Nombre de usuario</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="img-perfil-icono izquierda"><img src="img/default.jpg" alt="usuario" class="img-circulo"></div><div class="texto-centro opciones-menu-altura izquierda"><p>Nombre de usuario</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="img-perfil-icono izquierda"><img src="img/default.jpg" alt="usuario" class="img-circulo"></div><div class="texto-centro opciones-menu-altura izquierda"><p>Nombre de usuario</p></div></li></a>
            </ul>
        </div>
    </nav>
    <div class="vinculos">
        <a href="AutoresSeguidos">Ver todos</a>
    </div>
</div>
<div id="administrador" class="menuSlide menu-perfil oculto">
    <nav class="contenedor-menu-perfil">
        <div class="opciones-menu">
            <ul>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p>Perfil</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p>Ver reportes</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p>Reportes pendientes</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p>Obras bloqueadas</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p>Usuarios bloqueados</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p>Cambiar contraseña</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p>Cerrar sesión</p></div></li></a>
            </ul>
        </div>
    </nav>
</div>