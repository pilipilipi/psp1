package comunicacionesRed.ejercicio04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 5000;

		try (Socket socket = new Socket(host, puerto);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

			String mensaje = entrada.readLine();
			System.out.println(mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
