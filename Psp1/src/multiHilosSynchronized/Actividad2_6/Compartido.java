package multiHilosSynchronized.Actividad2_6;

import java.io.File;
import java.io.IOException;

public class Compartido {

    public static void main(String[] args) throws IOException {

        File f = new File("Actividad2_6.txt");

        Object lock = new Object();

        Thread tEsc = new Thread(new HiloEscritor(f, lock));
        Thread tLect = new Thread(new HiloLector(f, lock));

        tLect.start();
        tEsc.start();
    }
}