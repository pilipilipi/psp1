package hilosJava.ejemplo01;

public class Main {

	public static void main(String[] args) {
		int acc = 0;
		
		while(true) {
			Tic tic = new Tic();
			Tac tac = new Tac();
			
			tic.start();
			tac.start();

			if(acc++ == 1000) {
				break;
			}
		}

	}

}
