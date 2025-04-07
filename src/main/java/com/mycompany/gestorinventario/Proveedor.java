package com.mycompany.gestorinventario;


public class Proveedor extends Persona {
    public Proveedor(String nombre, String contacto) {
        super(nombre, contacto);
    }

    // Métodos específicos de Proveedor si es necesario
    public void mostrarProveedor() {
        System.out.println("Proveedor:");
        mostrarDatos(); // Llamamos al método de la clase padre
    }
}