package comunicacionesRed.ejercicios01.ej03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		final String HOST = "localhost";
		final int PUERTO = 5000;

		try (DatagramSocket socket = new DatagramSocket(); 
				Scanner sc = new Scanner(System.in)) {

			InetAddress direccionServidor = InetAddress.getByName(HOST);

			while (true) {
				System.out.print("Introduce cadena: ");
				String texto = sc.nextLine();

				byte[] envio = texto.getBytes();
				DatagramPacket paqueteEnvio = new DatagramPacket(envio, envio.length, direccionServidor, PUERTO);

				socket.send(paqueteEnvio);

				if (texto.trim().isEmpty() || texto.equalsIgnoreCase("FIN")) {
					break;
				}

				byte[] buffer = new byte[1024];
				DatagramPacket paqueteRespuesta = new DatagramPacket(buffer, buffer.length);

				socket.receive(paqueteRespuesta);

				String respuesta = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength());

				System.out.println(">> ECO: " + respuesta);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
