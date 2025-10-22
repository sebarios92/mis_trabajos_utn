package edu.utn.tp6;

public class App {
    public static void main(String[] args) {
        // Crear un inventario
        Inventario inventario = new Inventario();

        // Crear algunos productos
        Producto p1 = new Producto("Manzanas", 1200.50, 30, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("Notebook", 650000, 5, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("Campera", 45000, 12, CategoriaProducto.ROPA);
        Producto p4 = new Producto("Licuadora", 90000, 8, CategoriaProducto.HOGAR);

        // Agregar productos al inventario
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);

        // Mostrar todos los productos
        System.out.println("=== LISTA DE PRODUCTOS ===");
        inventario.listarProductos();

        // Buscar un producto por nombre
        System.out.println("\nBuscando producto 'Notebook':");
        Producto buscado = inventario.buscarProducto("Notebook");
        if (buscado != null) {
            System.out.println("Encontrado: " + buscado);
        } else {
            System.out.println("No se encontró el producto.");
        }
    }
}