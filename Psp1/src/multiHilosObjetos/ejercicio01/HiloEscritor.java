package multiHilosObjetos.ejercicio01;

import java.util.List;

public class HiloEscritor implements Runnable {
	List<Integer> lista;
	Object lock; 
	private static int acc = 0; 
	
	public HiloEscritor(List<Integer> lista, Object lock) { 
		this.lista = lista;
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) { 
			try {
				
				if (acc > 0) {
					lock.wait();
				}

				for (int i = 0; i < 10000; i++) {
					lista.add(acc);
					//System.out.println(acc);
				}
				acc++; 
				lock.notify(); 

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}