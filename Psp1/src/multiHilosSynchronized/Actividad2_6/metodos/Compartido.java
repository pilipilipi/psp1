package multiHilosSynchronized.Actividad2_6.metodos;

import java.io.*;

public class Compartido {

    private File f;
    private boolean hayDatos = false;

    public Compartido(File f) {
        this.f = f;
    }
	
	public static void main(String[] args) {

        File f = new File("Actividad2_6.txt");
        Compartido compartido = new Compartido(f);

        Thread lector = new Thread(new HiloLector(compartido));
        Thread escritor = new Thread(new HiloEscritor(compartido));

        lector.start();
        escritor.start();
    }


    public synchronized void escribir(String texto) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(f, true))) {
            pw.println(texto);
            hayDatos = true;

            notifyAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void leer() {
        try {
            while (!hayDatos) {
                wait();
            }

            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            hayDatos = false; 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

