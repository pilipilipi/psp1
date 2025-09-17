package pruebas.POO023;

import java.util.ArrayList;
import java.util.List;

public class Foto {

	static List<Comentario> comentarios = new ArrayList<>();
	private String atributos, descripcion, url;
	
	
	public static List<Comentario> getComentarios() {
		return comentarios;
	}
	public static void setComentarios(List<Comentario> comentarios) {
		Foto.comentarios = comentarios;
	}
	public String getAtributos() {
		return atributos;
	}
	public void setAtributos(String atributos) {
		this.atributos = atributos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
