package multiHilosJava.ejercicio07;

public class AreaTriangulo implements Runnable {
	int base, altura;
	
	public AreaTriangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public void run() {
		System.out.println("Area = " + base + " x " + altura + " / 2 = " + (base * altura) / 2);		
	}

}
