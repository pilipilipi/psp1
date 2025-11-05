package multiHilosJava.ejercicio04;

public class VariosHilosR {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 5; i++) {
			HiloCR hc = new HiloCR(i);
			Thread t = new Thread(hc);
			t.start();
		}
		
		System.out.println("Todos los hilos creados");
	}
}
