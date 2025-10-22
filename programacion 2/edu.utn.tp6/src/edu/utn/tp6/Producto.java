package edu.utn.tp6;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private CategoriaProducto categoria;

    // Constructor
    public Producto(String nombre, double precio, int stock, CategoriaProducto categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    // Setter
    public void setStock(int stock) {
        this.stock = stock;
    }

    // toString: muestra la información del producto
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", categoría=" + categoria +
                '}';
    }
}