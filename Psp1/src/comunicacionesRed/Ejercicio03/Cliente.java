package comunicacionesRed.Ejercicio03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String host = "localhost";
		int puerto = 5000;

		try (Socket socket = new Socket(host, puerto);
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {
			

			System.out.print("Ingresa un número: ");
			int n = Integer.parseInt(sc.nextLine());

			salida.println(n);

			String respuesta = entrada.readLine();
			System.out.println("El cuadrado: " + respuesta);

			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
