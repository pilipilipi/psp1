package multiHilosSynchronized.Actividad2_6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HiloEscritor implements Runnable {

    File f;
    Object lock;

    public HiloEscritor(File f, Object lock) {
        this.f = f;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(f, true))) {
                
                pw.println(fechaHoraActual());

                lock.notifyAll();

            } catch (IOException e) {
                System.out.println("Error al escribir el archivo: " + e.getMessage());
            }
        }
    }

    public static String fechaHoraActual() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
        return LocalDateTime.now().format(formato);
    }
}
