package multiHilosObjetos.ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class Check {
	public static void main(String[] args) {
//		File f = new File("enterosIguales");
//		// 1. Crear un objeto de bloqueo/monitor compartido
		List<Integer> lista = new ArrayList<>();
		Object lock = new Object(); 
		
		for(int i = 0; i < 10; i++) { 
			Thread tEsc = new Thread(new HiloEscritor(lista, lock));
			Thread tLect = new Thread(new HiloLector(lista, lock));
			
			tEsc.start();
			tLect.start();
		}
	}
}
