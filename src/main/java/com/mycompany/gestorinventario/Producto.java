
package com.mycompany.gestorinventario;

public class Producto extends Articulo {
    private String categoria;

    public Producto(String nombre, double precio, int stock, String categoria) {
        super(nombre, precio, stock);
        this.categoria = categoria;
    }

    // Métodos getters y setters
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método para mostrar los detalles del producto
    public void mostrarProducto() {
        System.out.println("Producto:");
        mostrarArticulo(); // Llamamos al método de la clase padre
        System.out.println("Categoria: " + categoria);
    }
}