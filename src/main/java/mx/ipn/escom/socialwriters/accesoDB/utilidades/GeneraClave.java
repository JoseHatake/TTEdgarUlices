package mx.ipn.escom.socialwriters.accesoDB.utilidades;

import java.util.Random;

public class GeneraClave {
	
	 public GeneraClave(){
		 
	 }
	 
	 public String generaPassword() {
	        String pass = "";
	        char[] caracteres;
	        int longitud = new Random().nextInt(5) + 8;
	        caracteres = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	        for (int i = 0; i < longitud; i++) {
	            pass += caracteres[new Random().nextInt(caracteres.length)];
	        }
	        return pass;
	    }
	
}
