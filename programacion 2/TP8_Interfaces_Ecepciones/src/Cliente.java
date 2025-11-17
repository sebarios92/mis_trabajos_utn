public class Cliente implements Notificable {

    private String nombre;
    private String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public void notificar(String mensaje) {
        // Para el TP alcanza con mostrar por consola
        System.out.println("Notificación para " + nombre + " (" + email + "): " + mensaje);
    }

    public String getNombre() {
        return nombre;
    }
}
