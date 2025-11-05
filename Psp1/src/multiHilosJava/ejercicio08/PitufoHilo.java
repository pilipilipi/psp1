package multiHilosJava.ejercicio08;

public class PitufoHilo implements Runnable {
	
	String nombre;
	
	public PitufoHilo(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 3; i ++) {
			System.out.println(this.nombre + " come un " + i + "º pan con queso");
		}	
		System.out.println(this.nombre + " terminó");
	}
}
