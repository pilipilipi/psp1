package multiHilosSynchronized.barberos;


public class Barbero implements Runnable {

	private final Barberia barberia;

    public Barbero(Barberia barberia) {
        this.barberia = barberia;
    }

    @Override
    public void run() {
        try {
            while (true) {
                barberia.atenderCliente();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
