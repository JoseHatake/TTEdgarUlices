<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="iniciar-sesion" class="menuSlide menu-perfil oculto">
    <form action="IniciarSesion" method="POST">
        <table class="contenedor-menu-perfil">
            <tbody>
                <tr>
                    <td align="left"><label for="usuario" style="margin-right: 10px;">Usuario</label></td>
                    <td><input type="text" name="usuario" placeholder="Usuario" maxlength="20"></td>
                </tr>
                <tr>
                    <td align="left"><label for="clave" style="margin-right: 10px;">Contrase�a</label></td>
                    <td><input type="password" name="clave" placeholder="�����" maxlength="20"></td>
                </tr>
            </tbody>
        </table>
        <input type="submit" class="boton-formulario" value="Iniciar">
    </form>
    <div class="vinculos">
        <a href="BuscarInformacionFormularios?metodoDeBusqueda=3&esAjax=false&direccion=NuevoUsuario.jsp">Registrarse</a>
        <br>
        <a href="RecuperarCuenta">Olvid� su contrase�a?</a>
    </div>
</div>
<div id="usuario" class="menuSlide menu-perfil oculto">
    <nav class="contenedor-menu-perfil">
        <div class="opciones-menu">
            <ul>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p>Perfil</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p>+ Obra</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p>+ Cap�tulo</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p>Cambiar contrase�a</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opciones-menu-altura izquierda"><p>Cerrar sesi�n</p></div></li></a>
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
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p>Cambiar contrase�a</p></div></li></a>
                <a href="index.jsp"><li class="padding-menu"><div class="texto-centro opcion-menu-altura izquierda"><p>Cerrar sesi�n</p></div></li></a>
            </ul>
        </div>
    </nav>
</div>