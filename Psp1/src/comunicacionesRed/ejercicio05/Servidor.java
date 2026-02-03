package comunicacionesRed.ejercicio05;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 5000;
        int maxClientes = 0;

        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            System.out.print("Ingresa el número máximo de clientes: ");
            maxClientes = sc.nextInt();
        }

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto + "...");

            for (int i = 1; i <= maxClientes; i++) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente " + i + " conectado: " + cliente.getInetAddress());

                try (PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)) {
                    salida.println("Eres el cliente número " + i);
                }

                cliente.close();
                System.out.println("Cliente " + i + " desconectado.");
            }

            System.out.println("Se alcanzó el máximo de clientes. Servidor cerrado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
