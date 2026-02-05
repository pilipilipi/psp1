package multiHilosSynchronized.barberos;

public class Barberia {
	
	private final int sillas;
	private int clientes = 0;
	
	public Barberia(int sillas) {
		this.sillas = sillas;
	}
	
	public synchronized boolean entraCliente(String c) {
		
		if(clientes < sillas) {
			clientes++;
			System.out.println(c + " se sienta. Sillas libres: " + (sillas - clientes));
			notifyAll();
			return true;
			
		} else {
			System.out.println("No hay sillas");
			return false;
		}
	}
	
	public synchronized void atenderCliente() throws InterruptedException {
        while (clientes == 0) {
            System.out.println(Thread.currentThread().getName() + " duerme porque no hay clientes.");
            wait(); 
        }
        clientes--;
        System.out.println(Thread.currentThread().getName() + " está afeitando a un cliente. Sillas libres: " + (sillas - clientes));
    }

}
