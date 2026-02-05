package multiHilosSynchronized.banco;

class CuentaBancaria {
    private int saldo;

    public CuentaBancaria(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Método sincronizado para ingresar dinero
    public synchronized void ingresar(int cantidad) {
        saldo += cantidad;
        System.out.println(Thread.currentThread().getName() + " ingresa " + cantidad + " → Saldo: " + saldo);
    }

    // Método sincronizado para retirar dinero
    public synchronized void retirar(int cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println(Thread.currentThread().getName() + " retira " + cantidad + " → Saldo: " + saldo);
        } else {
            System.out.println(Thread.currentThread().getName() + " intenta retirar " + cantidad + " → Saldo insuficiente: " + saldo);
        }
    }

    public int getSaldo() {
        return saldo;
    }
}
