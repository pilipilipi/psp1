package multiHilosSynchronized.Actividad2_6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HiloLector implements Runnable {
	File f;
	Object lock;
	String linea = "";

	public HiloLector(File f, Object lock) {
		this.f = f;
		this.lock = lock;
	}

	@Override
	public void run() {

		synchronized (lock) {
			try {
				while (f.length() == 0) {
					lock.wait();
				}
				
				try {

					if (f.length() == 0) {
						System.out.println("Archivo vacío.");
					}

					try (BufferedReader br = new BufferedReader(new FileReader(f))) {
						while ((linea = br.readLine()) != null) {

							System.out.println(linea);
						}

					} catch (IOException e) {
						System.out.println("Error al leer el archivo: " + e.getMessage());
					}

					lock.notifyAll();

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}