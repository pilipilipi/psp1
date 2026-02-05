package multiHilosSynchronized.banco;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CuentaBancaria cuenta = new CuentaBancaria(100);

	    // Arrays de hilos
	    Thread[] hilos = new Thread[40 + 20 + 60 + 40 + 20 + 60];
	    int index = 0;

	    // 40 ingresos de 100
	    for (int i = 0; i < 40; i++) {
	        hilos[index++] = new Thread(new Transaccion(cuenta, 100, true), "Ingreso100-" + (i+1));
	    }

	    // 20 ingresos de 50
	    for (int i = 0; i < 20; i++) {
	        hilos[index++] = new Thread(new Transaccion(cuenta, 50, true), "Ingreso50-" + (i+1));
	    }

	    // 60 ingresos de 20
	    for (int i = 0; i < 60; i++) {
	        hilos[index++] = new Thread(new Transaccion(cuenta, 20, true), "Ingreso20-" + (i+1));
	    }

	    // 40 retiros de 100
	    for (int i = 0; i < 40; i++) {
	        hilos[index++] = new Thread(new Transaccion(cuenta, 100, false), "Retiro100-" + (i+1));
	    }

	    // 20 retiros de 50
	    for (int i = 0; i < 20; i++) {
	        hilos[index++] = new Thread(new Transaccion(cuenta, 50, false), "Retiro50-" + (i+1));
	    }

	    // 60 retiros de 20
	    for (int i = 0; i < 60; i++) {
	        hilos[index++] = new Thread(new Transaccion(cuenta, 20, false), "Retiro20-" + (i+1));
	    }

	    // Iniciar todos los hilos
	    for (Thread t : hilos) {
	        t.start();
	    }

	    // Esperar a que terminen todos
	    for (Thread t : hilos) {
	        t.join();
	    }

	    System.out.println("Saldo final: " + cuenta.getSaldo());
	}

}
