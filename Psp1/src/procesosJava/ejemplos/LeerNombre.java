package procesosJava.ejemplos;

//import java.util.Scanner;

public class LeerNombre {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);

		if (args.length < 1) {
			System.exit(-1);

		} else {
			System.out.println("El nombre es: " + args[0]);
			System.exit(0);
		}
	}

}
