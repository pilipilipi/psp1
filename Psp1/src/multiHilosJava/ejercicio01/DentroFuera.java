package multiHilosJava.ejercicio01;

public class DentroFuera {
	
	public static void main(String[] args) {
		HiloFor hf = new HiloFor();
		hf.start();
		
		for(int i = 1; i <= 10; i++) {
			System.out.println("Estoy fuera del hilo");
		}
	}	
}
