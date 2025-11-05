package multiHilosJava.ejercicio01;

public class HiloFor extends Thread {

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("Estoy dentro del hilo");
		}
	}

}
