package comunicacionesRed.Ejercicio01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {

		int Puerto = 6000;// Puerto
		ServerSocket Servidor = new ServerSocket(Puerto);
		System.out.println("Escuchando en " + Servidor.getLocalPort());
		Socket cliente1= Servidor.accept();//esperando a un cliente
		//realizar acciones con cliente1
		System.out.println("Cliente 1 " + cliente1.getLocalPort());
		Socket cliente2 = Servidor.accept();//esperando a otro cliente
		//realizar acciones con cliente2
		System.out.println("Cliente 2 " + cliente2.getLocalPort());
		Servidor.close(); //cierro socket servidor
	}
}
