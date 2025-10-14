package procesosJava.practica13;

public class Suma {

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
