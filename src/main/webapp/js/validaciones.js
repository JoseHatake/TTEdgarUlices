function usuarioDisponible(itemUsuario,itemSubmit) {
	var usuario = id(itemUsuario).value;
	if (usuario.length >= 5){
		buscarUsuarioDisponible(itemUsuario,itemSubmit);
	}
	else{
		ActiveItem(itemSubmit,true);
		styleValidateInput(itemUsuario,1);
	}
}
function validaCamposIguales(item1,item2,itemSubmit,tipoCampo) {
	/*
	 * El tipoCampo va a depender de si es correo o contraseña
	 * */
	var campo1,campo2,campo1Valor,campo2Valor;
	campo1 = id(item1);
	campo2 = id(item2);
	campo1Valor = campo1.value;
	campo2Valor = campo2.value;
	if (campo1Valor.length == campo2Valor.length && campo1Valor.length >= 7) {
		if (campo1Valor == campo2Valor) {
			styleValidateInput(item1,3);
			styleValidateInput(item2,3);
			if (tipoCampo == 1) {
				//Valida correo
				buscarCorreoDisponible(item1,itemSubmit);
			}
			else{
				//Valida contraseña
			}
		}
		else{
			styleValidateInput(item1,2);
			styleValidateInput(item2,2);
			ActiveItem(itemSubmit,false);
		}
	}
	else{
		styleValidateInput(item1,1);
		styleValidateInput(item2,1);
		ActiveItem(itemSubmit,true);
	}
}