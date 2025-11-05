package multiHilosJava.ejercicio02;

public class HiloC extends Thread {
	
	int c;
	
	public HiloC(int c) {
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
