package comunicacionesRed.ejercicio05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

public class Servidor {
	public static void main(String[] args) {

		final int PUERTO = 5000;

		try (DatagramSocket socket = new DatagramSocket(PUERTO)) {

			socket.setSoTimeout(50000);
			System.out.println("Servidor UDP iniciado...");

			byte[] buffer = new byte[1024];
			boolean activo = true;

			while (activo) {
				try {
					DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
					socket.receive(paqueteRecibido);

					String mensaje = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());

					System.out.println("Recibido: " + mensaje);

					if (mensaje.equals("*")) {
						activo = false;
					} else {
						String respuesta = mensaje.toUpperCase();
						byte[] datosRespuesta = respuesta.getBytes();

						DatagramPacket paqueteRespuesta = new DatagramPacket(datosRespuesta, datosRespuesta.length,
								paqueteRecibido.getAddress(), paqueteRecibido.getPort());

						socket.send(paqueteRespuesta);
					}

				} catch (SocketTimeoutException e) {
					System.out.println("Tiempo de espera agotado. Cerrando servidor...");
					activo = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
