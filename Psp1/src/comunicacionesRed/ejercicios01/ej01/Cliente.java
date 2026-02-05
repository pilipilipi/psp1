package comunicacionesRed.ejercicios01.ej01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		final int PUERTO = 5000;
		final String HOST = "localhost";

		try (Socket socket = new Socket(HOST, PUERTO);
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
				Scanner sc = new Scanner(System.in)) {

			String txt, eco;

			while (true) {
				System.out.println("Introduce una cadena: ");
				txt = sc.nextLine();

				if (txt == null || txt.isEmpty()) {
					break;
				}

				salida.println(txt);
				eco = entrada.readLine();

				System.out.println(">>ECO: " + eco);
			}

			System.out.println("cliente finalizado");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
