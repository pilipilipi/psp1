package comunicacionesRed.Ejercicio02;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 5000;

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto + "...");

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado: " + cliente.getInetAddress());

            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

            String texto;
            while ((texto = entrada.readLine()) != null) {
                System.out.println("Recibido del cliente: " + texto);
                salida.println(texto.toUpperCase());
            }

            cliente.close();
            System.out.println("Cliente desconectado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
