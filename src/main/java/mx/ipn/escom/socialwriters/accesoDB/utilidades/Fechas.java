package mx.ipn.escom.socialwriters.accesoDB.utilidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fechas {
	
	public Fechas(){
		super();
	}
	
	public Date fechaActual(String formatoFecha){
		SimpleDateFormat format = new SimpleDateFormat(formatoFecha);
		GregorianCalendar gc = new GregorianCalendar(); 
        Date fechaHoraActual = null;
        Calendar calendar = Calendar.getInstance();

        int hora = gc.get(Calendar.HOUR_OF_DAY);
        int minutos = gc.get(Calendar.MINUTE);
        int segundos = gc.get(Calendar.SECOND);
        
        calendar.set(Calendar.HOUR, hora);
        calendar.set(Calendar.MINUTE, minutos);
        calendar.set(Calendar.SECOND, segundos);
        try {
			fechaHoraActual = format.parse(format.format(calendar.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return fechaHoraActual;
	}
	
	public String parseDate(String fecha) {
		String fechaNacimiento = new String();
		DateFormat parser,formater;
		parser = new SimpleDateFormat("yyyy-MM-dd");
		formater = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechaNacimiento = formater.format(parser.parse(fecha));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaNacimiento;
	}
}
