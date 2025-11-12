package multiHilosObjetos.ejercicio01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class HiloLector implements Runnable {
	File f;

	public HiloLector(File f) {
		this.f = f;
	}

	@Override
	public void run() {
		comprobarArchivo(f);
	}

	public synchronized void comprobarArchivo(File f) {
//		int val = lista.get(0);
//
//		for (int num : lista) {
//			if (val != num) {
//				System.out.println("Valores incorrectos");
//			} else {
//				System.out.println("valores correctos");
//			}
//		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))){
			String s = br.readLine(), linea;
			
			while ((linea = br.readLine()) != null) {
				
				if(!s.equals(linea)) {
					System.out.println("Incorrecto");
					break;
				}
			}
			
			System.out.println(s + "Correcto");
			notify();
			
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
