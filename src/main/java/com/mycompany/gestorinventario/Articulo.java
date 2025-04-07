

package com.mycompany.gestorinventario;

public class Articulo {
    protected String nombre;
    protected double precio;
    protected int stock;

    public Articulo(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método para mostrar los datos comunes
    public void mostrarArticulo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: L." + precio);
        System.out.println("Stock: " + stock);
    }
}