function id(tag) {
	return document.getElementById(tag);
}
function className(name) {
	return document.getElementsByClassName(name);
}
function selecciona(nameItem) {
	var item = id(nameItem);
	if (item.checked)
		item.checked = false;
	else
		item.checked = true;
}
function enableItem(item) {
	var elem = id(item);
	elem.disabled = false;
}
function desableItem(item) {
	var elem = id(item);
	elem.disabled = true;
}
function ActiveItem(item,estado) {
	if (estado)
		enableItem(item);
	else
		desableItem(item);
}
function styleDisplayItem(item,estado) {
	var elem = id(item);
	if (estado)
		elem.style.display = 'block';
	else
		elem.style.display = 'none';
}
function styleValidateInput(item,estado) {
	var elem = id(item);
	switch(estado){
		case 1:
			elem.style.borderColor = '#DDDDDD';
			elem.style.borderWidth = '1px';
			break;
		case 2:
			elem.style.borderColor = 'red';
			elem.style.borderWidth = '2px';
			break;
		case 3:
			elem.style.borderColor = 'green';
			elem.style.borderWidth = '2px';
			break;
	}
}
function switchEstado(item) {
	var elem = id(item);
	var estado = elem.style.display;
	if (estado == 'block')
		styleDisplayItem(item,false);
	else
		styleDisplayItem(item,true);
}
function asignaImg(idImg,imagen){
    var img = id(idImg);
    img.src = "data:image/jpeg;base64," + imagen;
}
function crearOption(select,value,text) {
	var x = id(select);
	var option = document.createElement("option");
	option.value = value;
	option.text = text;
	x.add(option);
}
function borrarCombo(combo,numItems) {
	var x = id(combo);
	for (n = 0; n <= numItems; n++) {
		x.remove(x[n]);
	}
}