package hilosJava.ejemplo01;

public class Tic extends Thread {
	private void syso() {		
		System.out.println("TIC");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.syso();
	}
}
