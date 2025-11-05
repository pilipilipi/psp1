package multiHilosJava.ejercicio03;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int acc = 0;
		boolean ticTac = true;

		while (true) {
			Tic tic = new Tic();
			Tac tac = new Tac();

			tic.start();
			ticTac = !ticTac;
			tic.join();

			tac.start();
			ticTac = !ticTac;
			tac.join();

			if (acc++ == 1000) {
				break;
			}
		}
	}
}
