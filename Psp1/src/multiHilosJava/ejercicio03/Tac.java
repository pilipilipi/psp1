package multiHilosJava.ejercicio03;

public class Tac extends Thread {

	@Override
	public void run() {
		System.out.println("TAC");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}
