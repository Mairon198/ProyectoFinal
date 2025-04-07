package com.mycompany.gestorinventario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorInventario {
    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private Usuario usuarioActivo;

    public GestorInventario() {
        productos = new ArrayList<>();
        proveedores = new ArrayList<>();
    }

    // Metodo para iniciar sesion
    public void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese la contrasena: ");
        String contrasena = scanner.nextLine();

        // Validación de usuarios
        if ("admin".equals(nombreUsuario) && "1234".equals(contrasena)) {
            usuarioActivo = new Usuario("administrador", "admin", contrasena);
            System.out.println("Usuario administrador ha iniciado sesion.");
        } else if ("usuario1".equals(nombreUsuario) && "1234".equals(contrasena)) {
            usuarioActivo = new Usuario("Mairon", "usuario1", contrasena);
            System.out.println("Usuario Mairon ha iniciado sesion.");
        } else if ("usuario2".equals(nombreUsuario) && "1234".equals(contrasena)) {
            usuarioActivo = new Usuario("Laura", "usuario2", contrasena);
            System.out.println("Usuario Laura ha iniciado sesion.");
        } else if ("usuario3".equals(nombreUsuario) && "1234".equals(contrasena)) {
            usuarioActivo = new Usuario("Alejandra", "usuario3", contrasena);
            System.out.println("Usuario Alejandra ha iniciado sesion.");
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    // Metodo para agregar un proveedor
    public void agregarProveedor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del proveedor: ");
        String nombreProveedor = scanner.nextLine();

        System.out.print("Ingrese el contacto del proveedor: ");
        String contactoProveedor = scanner.nextLine();

        // Crear proveedor y agregarlo
        Proveedor proveedor = new Proveedor(nombreProveedor, contactoProveedor);
        proveedores.add(proveedor);
        System.out.println("Proveedor agregado: " + nombreProveedor);
    }

    // Metodo para agregar un producto
    public void agregarProducto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese la cantidad en stock: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese la categoria del producto: ");
        String categoria = scanner.nextLine();

        // Ingresar el proveedor del producto directamente
        System.out.print("Ingrese el nombre del proveedor: ");
        String nombreProveedor = scanner.nextLine();

        System.out.print("Ingrese el contacto del proveedor: ");
        String contactoProveedor = scanner.nextLine();

        // Crear proveedor si no existe
        Proveedor proveedor = new Proveedor(nombreProveedor, contactoProveedor);
        proveedores.add(proveedor);

        // Crear producto y agregarlo
        Producto producto = new Producto(nombreProducto, precio, cantidad, categoria);
        productos.add(producto);
        System.out.println("Producto agregado: " + nombreProducto);
    }

    // Metodo para retirar un producto
    public void retirarProducto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del producto a retirar: ");
        String nombreProducto = scanner.nextLine();

        // Buscar el producto
        Producto productoEncontrado = null;
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                productoEncontrado = producto;
                break;
            }
        }

        if (productoEncontrado != null) {
            System.out.print("Ingrese la cantidad a retirar: ");
            int cantidadRetiro = scanner.nextInt();

            if (productoEncontrado.getStock() >= cantidadRetiro) {
                productoEncontrado.setStock(productoEncontrado.getStock() - cantidadRetiro);
                System.out.println("Se retiraron " + cantidadRetiro + " unidades de " + productoEncontrado.getNombre());
            } else {
                System.out.println("No hay suficiente stock.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Metodo para listar productos
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n--- Listado de Productos ---");
            for (Producto producto : productos) {
                producto.mostrarProducto(); // Mostrar detalles del producto
            }
        }
    }

    // Metodo para mostrar alertas de stock bajo
    public void mostrarAlertasStockBajo() {
        System.out.println("\n--- Alertas de Stock Bajo ---");
        for (Producto producto : productos) {
            if (producto.getStock() < 5) { // Definimos que el stock bajo es menor a 5
                producto.mostrarProducto();
                System.out.println("¡ALERTA! Stock bajo.");
            }
        }
    }

    // Metodo para listar proveedores
    public void listarProveedores() {
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            System.out.println("\n--- Listado de Proveedores ---");
            for (Proveedor proveedor : proveedores) {
                proveedor.mostrarProveedor(); // Mostrar detalles del proveedor
            }
        }
    }

    // Metodo para mostrar el usuario activo
    public void mostrarUsuarioActivo() {
        if (usuarioActivo != null) {
            System.out.println("\n--- Usuario Activo ---");
            System.out.println("Nombre: " + usuarioActivo.getNombre());
            System.out.println("Usuario: " + usuarioActivo.getUsuario());
        } else {
            System.out.println("No hay usuario activo.");
        }
    }
}

