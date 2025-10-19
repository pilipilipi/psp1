package procesosJava.practica13;
/**
 * <p>
 * Este programa recibe dos números por línea de comandos,
 * verifica que sean válidos y muestra su suma por pantalla.
 * </p>
 * 
 * @author Pilar
 * @version 1.0
 */

public class Suma {

	 /**
     * Metodo principal que realiza la suma de dos números pasados como argumentos.
     * 
     * @param args Dos números enteros a sumar.
     */
	
	public static void main(String[] args) {

		int x, y;

		if (args.length == 2) {

			try {
				x = Integer.parseInt(args[0]);
				y = Integer.parseInt(args[1]);

				System.out.println(x + " + " + y + " = " + (x + y));
				System.exit(0);

			} catch (NumberFormatException e) {
				System.err.println("Error: Debes introducir valores numéricos válidos.");
				
			} catch (Exception e) {
				System.err.println("Se ha producido un error inesperado: " + e.getMessage());
			}

		} else {
			System.exit(-1);
		}
	}

}
