package procesosJava.ejemplos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ProcesoLeerNombre {

	public static void main(String[] args) throws IOException {
		// creamos objeto File al directorio donde está Ejemplo2
		File d = new File(".");
		// proceso a ejecutar es Ejemplo2
		ProcessBuilder pb = new ProcessBuilder("java", "LeerNombre");// java es el comando para ejecutar un class

		Process p = pb.start();
		// obtener la salida
		try {
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
