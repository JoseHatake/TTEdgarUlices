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
	var usuario = id(itemUsuario).value;
	var variables = "&usuario=" + usuario;
	variables += "&esAjax=" + true;
	
	ajax.open("POST", "BuscarInformacionFormularios?metodoDeBusqueda=1" + variables, true);
	ajax.send("");
}
function validaUsuarioDisponible() {
	if (ajax.readyState === 4) {
		if (ajax.status === 200) {
			var info = ajax.responseText;
			if (info == "true") {
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
function buscarCorreoDisponible(itemCorreo1,itemCorreo2,itemSubmit) {
	// Almacenamos en el control al funcion que se invocara cuando la peticion cambie de estado
	ajax = new XMLHttpRequest();
	ajax.onreadystatechange = validaCorreoDisponible;
	item[0] = itemCorreo1;
	item[1] = itemCorreo2;
	item[2] = itemSubmit;
	var correo = id(itemCorreo1).value;
	var variables = "&correo=" + correo;
	variables += "&esAjax=" + true;
	
	ajax.open("POST", "BuscarInformacionFormularios?metodoDeBusqueda=2" + variables, true);
	ajax.send("");
}
function validaCorreoDisponible() {
	if (ajax.readyState === 4) {
		if (ajax.status === 200) {
			var info = ajax.responseText;
			if (info == "true") {
				styleValidateInput(item[0],3);
				styleValidateInput(item[1],3);
				ActiveItem(item[2],true);
			} else {
				alert("El correo proporciona ya esta en uso, favor de colocar otro.");
				styleValidateInput(item[0],2);
				styleValidateInput(item[1],2);
				ActiveItem(item[2],false);
			}
		}
	}
}

/**
 * Valida si el correo esta disponible
 * */

/**
 * Cambia el valor de ranking que da el usuario
 * */
function rankeaUsuario(colectionItemName,numItem,resultado,usuarioRankea,usuarioRankeado) {
	ajax = new XMLHttpRequest();
	styleStarts(colectionItemName,numItem,resultado);
	
	var estrellas = id(resultado).value;
	var variables = "&estrellas=" + estrellas;
	variables += "&usuarioRankea=" + usuarioRankea;
	variables += "&usuarioRankeado=" + usuarioRankeado;
	variables += "&esAjax=" + true;
	
	ajax.open("POST", "BuscarInformacionFormularios?metodoDeBusqueda=7" + variables, true);
	ajax.send("");
}
/**
 * Cambia el valor de ranking que da el usuario
 * */

/**
 * Cambia el valor de ranking que da el usuario a la obra
 * */
function rankeaObraUsuario(colectionItemName,numItem,resultado,usuarioRankea,obraRankeada) {
	ajax = new XMLHttpRequest();
	styleStarts(colectionItemName,numItem,resultado);
	
	var estrellas = id(resultado).value;
	var variables = "&estrellas=" + estrellas;
	variables += "&idUsuario=" + usuarioRankea;
	variables += "&idObra=" + obraRankeada;
	variables += "&esAjax=" + true;
	
	ajax.open("POST", "BuscarInformacionFormularios?metodoDeBusqueda=10" + variables, true);
	ajax.send("");
}
/**
 * Cambia el valor de ranking que da el usuario a la obra
 * */