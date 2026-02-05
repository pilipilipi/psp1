package multiHilosSynchronized.barberos;

public class Main {

	public static void main(String[] args) {
		Barberia barberia = new Barberia(5);
		int acc = 0;
		
		for (int i = 1; i <= 2; i++) {
            new Thread(new Barbero(barberia), "Barbero-" + i).start();
        }
		
		 while (true) {
	            String nombre = "Cliente-" + acc++;
	            new Thread(new Cliente(nombre, barberia)).start();
	            
	        }
		
	}

}
