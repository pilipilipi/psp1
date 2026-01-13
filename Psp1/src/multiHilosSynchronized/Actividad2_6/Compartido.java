package multiHilosSynchronized.Actividad2_6;

import java.io.File;

public class Compartido {

	public static void main(String[] args) {
		File f = new File("Actividad2_6.txt");
		Object lock = new Object();

		for (int i = 0; i < 10; i++) {
			Thread tEsc = new Thread(new HiloEscritor(f, lock));
			Thread tLect = new Thread(new HiloLector(f, lock));

			tLect.start();
			tEsc.start();
		}
	}

}
