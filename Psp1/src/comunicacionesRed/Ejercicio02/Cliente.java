package comunicacionesRed.Ejercicio02;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        String host = "localhost";
        int puerto = 5000;

        try (Socket socket = new Socket(host, puerto)) {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Ingrese un texto: ");
            String texto = sc.nextLine();

            salida.println(texto);

            String respuesta = entrada.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);
            
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

