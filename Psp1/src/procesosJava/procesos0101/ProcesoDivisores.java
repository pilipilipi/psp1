package procesosJava.procesos0101;

import java.io.IOException;
import java.io.InputStream;

public class ProcesoDivisores {
	public static void main(String[] args) throws IOException {

		Process ps = new ProcessBuilder("java", "procesosJava.procesos0101.Divisores", args[0]).start();

		try {
			InputStream is = ps.getInputStream();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
