public class PayPal implements Pago {

    private String correoCuenta;

    public PayPal(String correoCuenta) {
        this.correoCuenta = correoCuenta;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pagando $" + monto + " con PayPal de la cuenta: " + correoCuenta);
    }
}
