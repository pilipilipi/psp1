package multiHilosObjetos.ejercicio01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Check {
	public static void main(String[] args) {
		File f = new File("enterosIguales");
		
		Thread tEsc = new Thread(new HiloEscritor(f));
		Thread tLect = new Thread(new HiloLector(f));
		
		tEsc.start();
		tLect.start();
	}
}
