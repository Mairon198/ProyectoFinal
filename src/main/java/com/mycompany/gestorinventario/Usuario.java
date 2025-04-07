package com.mycompany.gestorinventario;

public class Usuario extends Persona {
    private String usuario;
    private String contrasena;

    public Usuario(String nombre, String usuario, String contrasena) {
        super(nombre, ""); 
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Métodos getters y setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Método para mostrar los datos del usuario
    public void mostrarUsuario() {
        System.out.println("Usuario:");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Usuario: " + usuario);
    }
}