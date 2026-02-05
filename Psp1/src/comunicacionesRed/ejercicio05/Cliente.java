package comunicacionesRed.ejercicio05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		final int PUERTO = 5000;
		final String HOST = "localhost";

		try (DatagramSocket socket = new DatagramSocket(); Scanner sc = new Scanner(System.in)) {

			boolean activo = true;

			while (activo) {
				System.out.print("Introduce una cadena: ");
				String mensaje = sc.nextLine();

				byte[] datos = mensaje.getBytes();

				DatagramPacket paqueteEnvio = new DatagramPacket(datos, datos.length, InetAddress.getByName(HOST), PUERTO);

				socket.send(paqueteEnvio);

				if (mensaje.equals("*")) {
					activo = false;
				} else {
					byte[] buffer = new byte[1024];
					DatagramPacket paqueteRespuesta = new DatagramPacket(buffer, buffer.length);

					socket.receive(paqueteRespuesta);

					String respuesta = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength());

					System.out.println("Respuesta del servidor: " + respuesta);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
