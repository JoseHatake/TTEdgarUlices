function esBisiesto(ano) {
	var anoFlag = 2012;
	var conteo = ano-anoFlag;
	var deside = false;
	if (conteo%4 == 0)
		deside = true;
	else
		deside = false;
	return deside;
}
function diaMaxPorMes(mes,ano) {
	var diaMax = 0;
	switch(mes){
		case 1://Enero
		case 3://Marzo
		case 5://Mayo
		case 7://Julio
		case 8://Agosto
		case 10://Octubre
		case 12://Diciembre
			diaMax = 31;
			break;
		case 4://Abril
		case 6://Junio
		case 9://Septiembre
		case 11://Noviembre
			diaMax = 30;
			break;
		case 2://Febrero
			if (esBisiesto(ano))
				diaMax = 29;
			else
				diaMax = 28;
			break;
	}
	return diaMax;
}
function getMes(mes) {
	var aux = 0;
	switch(mes){
		case '01':
			aux = 1;
			break;
		case '02':
			aux = 2;
			break;
		case '03':
			aux = 3;
			break;
		case '04':
			aux = 4;
			break;
		case '05':
			aux = 5;
			break;
		case '06':
			aux = 6;
			break;
		case '07':
			aux = 7;
			break;
		case '08':
			aux = 8;
			break;
		case '09':
			aux = 9;
			break;
		case '10':
			aux = 10;
			break;
		case '11':
			aux = 11;
			break;
		case '12':
			aux = 12;
			break;
	}
	return aux;
}
function getDiaMesDosDigitos(dia) {
	if (dia < 10)
		return "0"+dia;
	else
		return dia;
}
function generarDias(anoIni,mesIni,item) {
	var anoSelected = id(anoIni).value;
	var mesSelected = id(mesIni).value;
	var countDias = diaMaxPorMes(getMes(mesSelected),anoSelected);
	var i = 0;

	var aux = id(item).length;
	var aux2;
	
	borrarCombo(item,aux);
	crearOption(item,"","D"+'\u00ED'+"a");
	
	for ( i = 1; i <= countDias; i++) {
		aux2 = getDiaMesDosDigitos(i);
		crearOption(item,aux2,aux2);
	}
}
function llenarSelectAnios(combo,anioIni,anioActual) {
	var i,tope;
	tope = id(combo).length;
	if (tope<=1) {
		for (i = anioActual; i >= anioIni; i--) {
			crearOption(combo,i,i);
		}
	}
}
function cambiarFormatoFecha(fecha) {
	return fecha.substring(8,10) + " de " + getMesName(fecha.substring(5,7)) + " de " + fecha.substring(0,4);
}