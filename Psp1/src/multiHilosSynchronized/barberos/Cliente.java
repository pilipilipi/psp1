package multiHilosSynchronized.barberos;

public class Cliente implements Runnable {
	
	private String nombre;
	private final Barberia barberia;
	
	public Cliente(String nombre, Barberia barberia) {
		this.nombre = nombre;
		this.barberia = barberia;
	}

	@Override
	public void run() {
		
		barberia.entraCliente(nombre);
	}

}
