package multiHilosSynchronized.ejercicio01;

import java.util.List;

public class HiloLector implements Runnable {
	List<Integer> lista;
	Object lock;

	public HiloLector(List<Integer> lista, Object lock) {
		this.lista = lista;
		this.lock = lock;
	}

	@Override
	public void run() {

		synchronized (lock) {
			try {
				while (lista.isEmpty()) {
					lock.wait();
				}
				boolean correcto = true;

				try {

					if (lista.isEmpty()) {
						System.out.println("Archivo vacío.");
						correcto = false;
					}

					for (int n : lista) {
						if (n != lista.get(0)) {
							correcto = false;
							System.out.println("Inorrecto");
							break;
						}
					}

					if (correcto) {
						System.out.println("Correcto");
					}

					lista.clear();
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