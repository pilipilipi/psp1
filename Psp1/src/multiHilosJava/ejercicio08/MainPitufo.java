package multiHilosJava.ejercicio08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainPitufo {

	public static void main(String[] args) {
		List<String> nombres = new ArrayList<>(Arrays.asList("Papá pitufo", "Pitufina", "Filósofo", "Pintor", "Gruñón",
				"Bromista", "Dormilón", "Tímido", "Tontín", "Bonachón", "Romántico"));
		
		for(String nombre: nombres) {
			PitufoHilo p = new PitufoHilo(nombre);
			Thread t = new Thread(p);
			
			t.start();
		}
	}
}