package procesosJava.practica13;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ProcesoSuma {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String x, y;
		
		System.out.println("Dime el primer numero");
		x = sc.nextLine();
		
		System.out.println("Dime el segundo numero");
		y = sc.nextLine();
		
		sc.close();
		
		Process ps = new ProcessBuilder("java", "procesosJava.practica13.Suma", x, y).start();
		
		try (InputStream is = ps.getInputStream()){
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			
		} try (InputStream err = ps.getErrorStream()){
			int c;
			while ((c = err.read()) != -1) {
				System.out.print((char) c);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
