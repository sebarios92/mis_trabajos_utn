public class MainEcommerce {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Sebastián", "sebastian@example.com");

        Pedido pedido = new Pedido(cliente);

        Producto p1 = new Producto("Mouse gamer", 15000);
        Producto p2 = new Producto("Teclado mecánico", 30000);
        Producto p3 = new Producto("Auriculares", 20000);

        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);
        pedido.agregarProducto(p3);

        System.out.println("\nProductos en el pedido:");
        for (Producto p : pedido.getProductos()) {
            System.out.println(" - " + p);
        }

        double total = pedido.calcularTotal();
        System.out.println("\nTotal del pedido: $" + total);

        // Cambio de estado del pedido
        pedido.setEstado("PAGADO");
        pedido.setEstado("ENVIADO");
        pedido.setEstado("ENTREGADO");

        System.out.println("\n=== Pago con Tarjeta de Crédito (con descuento) ===");
        TarjetaCredito tarjeta = new TarjetaCredito("Sebastián", "1234-5678-0000-9999");
        double totalConDescuento = tarjeta.aplicarDescuento(total);
        tarjeta.procesarPago(totalConDescuento);

        System.out.println("\n=== Pago con PayPal (sin descuento) ===");
        PayPal paypal = new PayPal("sebastian@paypal.com");
        paypal.procesarPago(total);
    }
}
