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
function validaCorreosIguales(item1,item2,itemSubmit) {
	var campo1,campo2,campo1Valor,campo2Valor;
	campo1 = id(item1);
	campo2 = id(item2);
	campo1Valor = campo1.value;
	campo2Valor = campo2.value;
	if (campo1Valor.length == campo2Valor.length && campo1Valor.length >= 7) {
		if (campo1Valor == campo2Valor) {
			styleValidateInput(item1,3);
			styleValidateInput(item2,3);
			buscarCorreoDisponible(item1,item2,itemSubmit);
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
function validaClavesIguales(item1,item2,itemSet,itemSubmit) {
	var campo1,campo2,campo1Valor,campo2Valor;
	campo1 = id(item1);
	campo2 = id(item2);
	campo1Valor = campo1.value;
	campo2Valor = campo2.value;
	if (campo1Valor.length == campo2Valor.length && campo1Valor.length >= 5) {
		if (campo1Valor == campo2Valor) {
			styleValidateInput(item1,3);
			styleValidateInput(item2,3);
			id(itemSet).value = hash(item1);
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