

package com.mycompany.gestorinventario;

public class Categoria {
    private String nombre;
    private String descripcion;

    // Constructor para inicializar la categoría
    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Métodos getter y setter para acceder y modificar atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para mostrar los datos de la categoría
    public void mostrarCategoria() {
        System.out.println("Categoria: " + nombre);
        System.out.println("Descripcion: " + descripcion);
    }
}
