package comunicacionesRed.ejercicios01.ej03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {

	public static void main(String[] args) {

		final int PUERTO = 5000;

		try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
			System.out.println("Servidor UDP escuchando en el puerto " + PUERTO);

			byte[] buffer = new byte[1024];

			while (true) {
				DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);

				socket.receive(paqueteRecibido);

				String mensaje = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());

				if (mensaje.trim().isEmpty() || mensaje.equalsIgnoreCase("FIN")) {
					System.out.println("Servidor finaliza.");
					break;
				}

				System.out.println("Recibiendo: " + mensaje);

				byte[] envio = mensaje.getBytes();
				DatagramPacket paqueteEnvio = new DatagramPacket(envio, envio.length, paqueteRecibido.getAddress(),
						paqueteRecibido.getPort());

				socket.send(paqueteEnvio);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
