package multiHilosJava.ejercicio05;

public class VariosHilosJoin {

	public static void main(String[] args) throws InterruptedException {
		
		for(int i = 1; i <= 5; i++) {
			HiloJoin hc = new HiloJoin(i);
			Thread t = new Thread(hc);
			t.start();
			t.join();
		}
		
		System.out.println("Todos los hilos creados");
	}
}
