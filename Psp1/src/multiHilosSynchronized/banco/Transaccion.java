package multiHilosSynchronized.banco;

class Transaccion implements Runnable {
    private CuentaBancaria cuenta;
    private int cantidad;
    private boolean esIngreso;

    public Transaccion(CuentaBancaria cuenta, int cantidad, boolean esIngreso) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.esIngreso = esIngreso;
    }

    @Override
    public void run() {
        if (esIngreso) {
            cuenta.ingresar(cantidad);
        } else {
            cuenta.retirar(cantidad);
        }
    }
}

