package POO011;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class cuentaBancaria {
	Scanner sc = new Scanner(System.in);

	private String numCuenta;
	private double saldo;
	private ArrayList<titular> titulares = new ArrayList<>();

	cuentaBancaria(String numCuenta, double saldo, titular titular) {

		this.numCuenta = numCuenta;
		this.saldo = saldo;
		anadirTitular(titular);

	}

	public ArrayList<titular> anadirTitular(titular titular) {

		if (titulares.size() < 3) {
			System.out.println("Introduce usuario:");
			titulares.add(titular);

		} else {
			System.out.println("Ya hay 3 usuarios, has llegado al maximo");
		}
		return titulares;
	}

	public void ingresarDinero() {

		System.out.println("Cuanto dinero quieres ingresar?");
		double dinero = Double.parseDouble(sc.nextLine());

		this.saldo += dinero;

	}

	public void retirarDinero() {

		System.out.println("Cuanto dinero quieres retirar?");
		double dinero = Double.parseDouble(sc.nextLine());

		if (this.saldo < dinero) {

			System.out.println("saldo insuficiente");

		} else {
			this.saldo -= dinero;
		}
	}

	public void borrarTitular(titular titular) {

		if (titulares.size() > 1) {
			Iterator<titular> it;

			it = titulares.iterator();

			while (it.hasNext()) {

				if (it.next().equals(titular)) {
					it.remove();

				} else {
					System.out.println("No existe ese usuario");
				}
			}
		} else {
			System.out.println("solo hay un titular, para eliminarlo añada otro previamente");
		}
	}

}
