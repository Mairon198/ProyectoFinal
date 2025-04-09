
package com.mycompany.gestorinventario;


public class Producto extends Articulo {
    private Categoria categoria;

    // Constructor que inicializa los atributos del producto y su categoría
    public Producto(String nombre, double precio, int stock, Categoria categoria) {
        super(nombre, precio, stock);
        this.categoria = categoria;
    }

    // Métodos getter y setter para acceder o modificar la categoría
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Método para mostrar los detalles del producto completo
    public void mostrarProducto() {
        System.out.println("Producto:");
        mostrarArticulo(); // Mostrar info heredada de Articulo
        if (categoria != null) {
            categoria.mostrarCategoria(); // Mostrar info de la categoría
        } else {
            System.out.println("Categoría: No asignada");
        }
    }
}
