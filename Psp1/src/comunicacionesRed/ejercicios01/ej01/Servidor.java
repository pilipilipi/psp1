package comunicacionesRed.ejercicios01.ej01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		final int PUERTO = 5000;

		try (ServerSocket servidor = new ServerSocket(PUERTO)) {
			System.out.println("Servidor escuchando en el puerto " + PUERTO + "...");

			try (Socket cliente = servidor.accept()) {
				System.out.println("Cliente conectado: " + cliente.getInetAddress());

				try (BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
						PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)) {

					String txt;
					
					while((txt = entrada.readLine()) != null) {
						salida.println(txt);
					}
				}
				System.out.println("Cliente desconectado");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
