package multiHilosSynchronized.Actividad2_6.metodos;

public class HiloLector implements Runnable {

    private Compartido compartido;

    public HiloLector(Compartido compartido) {
        this.compartido = compartido;
    }

    @Override
    public void run() {
        compartido.leer();
    }
}
