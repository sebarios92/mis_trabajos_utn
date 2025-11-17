import java.util.ArrayList;
import java.util.List;

public class Pedido implements Pagable {

    private List<Producto> productos;
    private String estado;
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.productos = new ArrayList<>();
        this.estado = "CREADO";
        this.cliente = cliente;
        notificarCambioEstado();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void quitarProducto(Producto producto) {
        productos.remove(producto);
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularTotal();
        }
        return total;
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarCambioEstado();
    }

    private void notificarCambioEstado() {
        if (cliente != null) {
            cliente.notificar("El estado de tu pedido ahora es: " + estado);
        }
    }

    public String getEstado() {
        return estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
