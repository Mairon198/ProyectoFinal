
package com.mycompany.gestorinventario;

public class Persona {
    protected String nombre;
    protected String contacto;

    public Persona(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    // Método para mostrar los datos comunes
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Contacto: " + contacto);
    }
}