

package com.mycompany.gestorinventario;


public class Categoria extends Articulo {
    private String descripcion;

    public Categoria(String nombre, double precio, int stock, String descripcion) {
        super(nombre, precio, stock);
        this.descripcion = descripcion;
    }

    // Métodos getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para mostrar los detalles de la categoría
    public void mostrarCategoria() {
        System.out.println("Categoria:");
        mostrarArticulo(); // Llamamos al método de la clase padre
        System.out.println("Descripcion: " + descripcion);
    }
}