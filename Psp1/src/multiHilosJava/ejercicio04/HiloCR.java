package multiHilosJava.ejercicio04;

public class HiloCR implements Runnable {
	
	int c;
	
	public HiloCR(int c) {
		this.c = c;		
		System.out.println("Creando hilo " + this.c);
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("Hilo " + this.c + " linea " + i);
		}
	}
}
