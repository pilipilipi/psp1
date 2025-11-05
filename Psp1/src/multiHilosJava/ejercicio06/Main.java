package multiHilosJava.ejercicio06;

public class Main {

	public static void main(String[] args) {
		Thread tp = new Thread(new HiloPar());
		Thread ti = new Thread(new HiloImpar());
		
		tp.start();
		ti.start();
	}
}
