function hash(itemGet) {
	var clave = id(itemGet).value;
	var hash = 0;
	
    for (i = 0; i < clave.length; i++) {
        chr = clave.charCodeAt(i);
        hash = ((hash << 5) - hash) + chr;
        hash = hash & hash; // Convierte a un entero de 32bit 
    }
    return hash;
}