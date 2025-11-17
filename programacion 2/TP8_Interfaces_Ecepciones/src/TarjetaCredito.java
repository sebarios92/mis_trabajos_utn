public class TarjetaCredito implements Pago, PagoConDescuento {

    private String titular;
    private String numero;

    public TarjetaCredito(String titular, String numero) {
        this.titular = titular;
        this.numero = numero;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pagando $" + monto + " con Tarjeta de Crédito de " + titular);
    }

    @Override
    public double aplicarDescuento(double monto) {
        // Ejemplo: 10% de descuento con tarjeta
        double montoConDescuento = monto * 0.90;
        System.out.println("Aplicando 10% de descuento con tarjeta. Total con descuento: $" + montoConDescuento);
        return montoConDescuento;
    }
}
