package edu.utn.tp6;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    // Constructor
    public Inventario() {
        productos = new ArrayList<>();
    }

    // Método para agregar un producto al inventario
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    // Método para listar todos los productos
    public void listarProductos() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    // Método para buscar un producto por nombre
    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
}