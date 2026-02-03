package comunicacionesRed.Ejercicio03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		int puerto = 5000;

		try (ServerSocket servidor = new ServerSocket(puerto)) {
			System.out.println("Servidor escuchando en el puerto " + puerto + "...");

			Socket cliente = servidor.accept();
			System.out.println("Cliente conectado: " + cliente.getInetAddress());

			try (BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)) {
				
				String texto;
				int n;
				while ((texto = entrada.readLine()) != null) {
					n = Integer.parseInt(texto);
					salida.println(n * n);
				}

				cliente.close();
				System.out.println("Cliente desconectado.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
