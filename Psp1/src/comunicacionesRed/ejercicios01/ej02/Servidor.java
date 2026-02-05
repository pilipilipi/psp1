package comunicacionesRed.ejercicios01.ej02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) {
		final int PUERTO = 5000;
		
		try(ServerSocket servidor = new ServerSocket(PUERTO)){
			System.out.println("Servidor escuchando en el puerto: " + PUERTO + "...");
			
			for(int i = 1; i <= 3; i++) {
				try(Socket cliente = servidor.accept()){
					
					System.out.println("Cliente " + i + " conectado: " + cliente.getInetAddress());
					
					try(PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)){
						
						salida.println("Eres el cliente numero: " + i);
					}
				}
				System.out.println("Desconexion...");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
