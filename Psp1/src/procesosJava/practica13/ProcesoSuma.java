package procesosJava.practica13;

import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Clase ProcesoSuma
 * <p>
 * Este programa solicita dos números al usuario, crea un proceso
 * para ejecutar la clase {@link Suma} y muestra el resultado
 * recibido por el flujo de salida del proceso.
 * </p>
 * 
 * @author [Tu Nombre]
 * @version 1.0
 */

public class ProcesoSuma {
	
	/**
     * Método principal que lanza el proceso de suma.
     * 
     * @param args Argumentos de linea de comandos (no usados).
     * @throws IOException Si ocurre un error de entrada/salida al ejecutar el proceso.
     */

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String x, y;

		System.out.println("Dime el primer numero");
		x = sc.nextLine();

		System.out.println("Dime el segundo numero");
		y = sc.nextLine();

		sc.close();

		Process ps = new ProcessBuilder("java", "procesosJava.practica13.Suma", x, y).start();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(), "UTF-8"));
			BufferedReader err = new BufferedReader(new InputStreamReader(ps.getErrorStream(), "UTF-8"))) {
			
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.print(linea);
			}
			
			while ((linea = err.readLine()) != null) {
		        System.err.println(linea);
		    }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
