var ajax;
var item = [];

/**
 * Valida si el nombre de usuario esta disponible
 * */
function buscarUsuarioDisponible(itemUsuario,itemSubmit) {
	// Almacenamos en el control al funcion que se invocara cuando la peticion cambie de estado
	ajax = new XMLHttpRequest();
	ajax.onreadystatechange = validaUsuarioDisponible;
	item[0] = itemUsuario;
	item[1] = itemSubmit;
	var variables = "&usuario=" + item[0];
	variables += "&esAjax=" + true;
	
	ajax.open("POST", "BuscarInformacionFormularios?metodoDeBusqueda=1" + variables, true);
	ajax.send("");
}
function validaUsuarioDisponible() {
	if (ajax.readyState === 4) {
		if (ajax.status === 200) {
			var info = ajax.responseText;
			if (info) {
				styleValidateInput(item[0],3);
				ActiveItem(item[1],true);
			} else {
				styleValidateInput(item[0],2);
				ActiveItem(item[1],false);
			}
		}
	}
}

/**
 * Valida si el nombre de usuario esta disponible
 * */

/**
 * Valida si el correo esta disponible
 * */
function buscarCorreoDisponible(itemCorreo,itemSubmit) {
	// Almacenamos en el control al funcion que se invocara cuando la peticion cambie de estado
	ajax = new XMLHttpRequest();
	ajax.onreadystatechange = validaCorreoDisponible;
	item[0] = itemCorreo;
	item[1] = itemSubmit;
	var variables = "&correo=" + item[0];
	variables += "&esAjax=" + true;
	
	ajax.open("POST", "BuscarInformacionFormularios?metodoDeBusqueda=2" + variables, true);
	ajax.send("");
}
function validaCorreoDisponible() {
	if (ajax.readyState === 4) {
		if (ajax.status === 200) {
			var info = ajax.responseText;
			if (info) {
				ActiveItem(item[1],true);
			} else {
				alert("El correo proporciona ya esta en uso, favor de colocar otro.");
				ActiveItem(item[1],false);
			}
		}
	}
}

/**
 * Valida si el correo esta disponible
 * */