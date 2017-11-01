$(document).ready(function () {
	/* Carga el menu correspondiente, dependiendo del contenedor asignado en al html */
	if ($("#1").length)
		$("#1").load('generales/menu-perfil.html #iniciar-sesion');
	else if($("#2").length)
		$("#2").load('generales/menu-perfil.html #usuario');
	else
		$("#3").load('generales/menu-perfil.html #administrador');
	/* Carga el menu correspondiente, dependiendo del contenedor asignado en al html */

	var cont1 = 0;
	var cont2 = 0;
	var bar = id('boton-perfil');
	$('.perfil').click(function () {
		if (cont1 == 1) {
			$('.menuSlide').slideUp("fast",function (){
				bar.style.borderBottomLeftRadius = "25px";
				bar.style.borderBottomRightRadius = "25px";
			});
			cont1 = 0;
		}
		else{
			$('.menuSlide').slideDown("fast",function (){});
			bar.style.borderBottomLeftRadius = "0px";
			bar.style.borderBottomRightRadius = "0px";
			cont1 = 1;
		}
	});
	$('.icon-menu').click(function () {
		if (cont2 == 1) {
			$('.menu-filtros').animate({
				left: "0"
			});
			cont2 = 0;
		}
		else{
			$('.menu-filtros').animate({
				left: "-100%"
			});
			cont2 = 1;
		}
	});
	$('.contenedor').click(function () {
		if (cont1 == 1) {
			$('.menuSlide').slideUp("fast",function (){
				bar.style.borderBottomLeftRadius = "25px";
				bar.style.borderBottomRightRadius = "25px";
			});
			cont1 = 0;
		}
		if (cont2 == 1) {
			$('.menu-filtros').animate({
				left: "-100%"
			});
			cont2 = 0;
		}
	});
});