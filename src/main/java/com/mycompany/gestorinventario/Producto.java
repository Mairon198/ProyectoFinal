
package com.mycompany.gestorinventario;

public class Producto extends Articulo {
    private Categoria categoria;

    public Producto(String nombre, double precio, int stock, Categoria categoria) {
        super(nombre, precio, stock);
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void mostrarProducto() {
        System.out.println("Producto:");
        mostrarArticulo();
        System.out.println("Categoría: " + categoria.getNombre());
        System.out.println("Descripción de la categoría: " + categoria.getDescripcion());
    }
}