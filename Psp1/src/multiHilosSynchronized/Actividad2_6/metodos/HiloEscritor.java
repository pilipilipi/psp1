package multiHilosSynchronized.Actividad2_6.metodos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HiloEscritor implements Runnable {

    private Compartido compartido;

    public HiloEscritor(Compartido compartido) {
        this.compartido = compartido;
    }

    @Override
    public void run() {
        compartido.escribir(fechaHoraActual());
    }

    public static String fechaHoraActual() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
		return LocalDateTime.now().format(formato);
	}
}
