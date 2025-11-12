package multiHilosObjetos.ejercicio01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HiloEscritor implements Runnable {
	File f;
	private static int acc = 0;

	public HiloEscritor(File f) {
		this.f = f;
	}

	@Override
	public void run() {
		escribirArchivo(f);
	}

	public synchronized void escribirArchivo(File f) {

		try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
			for (int i = 0; i < 10000; i++) {
				pw.println(acc);
			}

			acc++;
			notify();

			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
