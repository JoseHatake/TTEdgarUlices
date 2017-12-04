package mx.ipn.escom.socialwriters.accesoDB.utilidades;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;

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
	
	public Boolean renombrarDocumento(String archivo,String documentoViejo, String documentoNuevo) {
		File fileAntes,fileDespues;
		fileAntes = new File(contexto + ARCHIVERO + "/" + archivo + "/" + documentoViejo);
		fileDespues = new File(contexto + ARCHIVERO + "/" + archivo,documentoNuevo);
		return fileAntes.renameTo(fileDespues);
	}
	
	public String obtenerImagenCodificada(String archivo,String imagen) throws IOException {
		File file;
		Path filePath;
		file = new File(contexto + ARCHIVERO + "/" + archivo + "/" + imagen);
		filePath = Paths.get(contexto + ARCHIVERO + "/" + archivo + "/" + file.getName());
        byte[] bytes = Base64.getEncoder().encode(Files.readAllBytes(filePath));
        return new String(bytes, "UTF-8");
	}
	
	public void guardarCapitulo(String archivo, String capitulo)throws IOException {
				
		File file;
		file = new File(contexto + ARCHIVERO + "/" + archivo);
		try {
			
			FileUtils.writeStringToFile(file,capitulo,"UTF-8");
			
		}catch(Exception e){			
			e.printStackTrace();
			
		}
		
	}
	
	public String codificaCapitulo(String capitulo) {
		String capituloCodificado;
		String[] parrafos;
		
		parrafos = capitulo.split("\n");
		capituloCodificado="";
		
		for(int i =0; i<parrafos.length;i++) {
			capituloCodificado+="<p>";
			capituloCodificado+=parrafos[i]+"</p>";			
		}
		
		return capituloCodificado;
	}
	
	public List<String> cargaCapitulo(String archivo) {
		String capitulo="";
		String[] aux;
		List<String> parrafos = new ArrayList();
		File file;
		file = new File(contexto + ARCHIVERO + "/" + archivo);
		
		try {
			
			capitulo = FileUtils.readFileToString(file,"UTF-8");
			aux = capitulo.split("\n");
			for(int i=0; i< aux.length;i++) {
				parrafos.add(aux[i]);
				
			}
			
		}catch(Exception e){			
			e.printStackTrace();
			
		}
		
		return parrafos;
		
	}
}
