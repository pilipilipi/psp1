package multiHilosJava.ejercicio07;

public class Main {

	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++) {
			int x = (int) (Math.random() * 30 + 1);
			int y = (int) (Math.random() * 30 + 1);
			
			AreaTriangulo a = new AreaTriangulo(x, y);
			Thread t = new Thread(a);
			
			t.start();
		}
	}

}
