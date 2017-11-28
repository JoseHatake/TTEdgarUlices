package mx.ipn.escom.socialwriters.accesoDB.utilidades;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

public class Archivos {
	private String contexto;
	private final static String ARCHIVERO = "/archivero";
	
	public Archivos() {
		super();
	}

	public Archivos(String contexto) {
		super();
		this.contexto = contexto;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	public Boolean guardarImagenEnArchivo(FileItem item,String archivo,String nombre) {
		File file;
		Boolean flag;
		
		flag = true;
        try {
        		if (!this.existeArchivo(archivo))
				this.crearArchivo(archivo);
        		file = new File(contexto + ARCHIVERO + "/" + archivo, nombre);
			item.write(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
        return flag;
	}
	
	public Boolean existeArchivo(String archivo) {
		File file;
		file = new File(contexto + ARCHIVERO + "/" + archivo);
		return file.exists();
	}
	
	public Boolean exiteDocumento(String archivo,String documento) {
		File file;
		file = new File(contexto + ARCHIVERO + "/" + archivo + "/" + documento);
		return file.exists();
	}
	
	public void crearArchivo(String archivo) {
		File file;
		file = new File(contexto + ARCHIVERO + "/" + archivo);
		file.mkdirs();
	}
	
	public Boolean renombrarArchivo(String archivo, String nuevoNombre){
		File fileAntes,fileDespues;
		fileAntes = new File(contexto + ARCHIVERO + "/" + archivo);
		fileDespues = new File(contexto + ARCHIVERO + "/" + nuevoNombre);
		return fileAntes.renameTo(fileDespues);
	}
	
	public Boolean renombrarDocumento(String archivo,String documentoBiejo, String documentoNuevo) {
		File fileAntes,fileDespues;
		fileAntes = new File(contexto + ARCHIVERO + "/" + archivo + "/" + documentoBiejo);
		fileDespues = new File(contexto + ARCHIVERO + "/" + archivo,documentoNuevo);
		return fileAntes.renameTo(fileDespues);
	}
}
