package com.mycompany.gestorinventario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorInventario {
    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private Usuario usuarioActivo;

    // Constructor que inicializa las listas de productos y proveedores
    public GestorInventario() {
        productos = new ArrayList<>();
        proveedores = new ArrayList<>();
    }

    // Método para iniciar sesión con diferentes usuarios predefinidos
    public void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese la contrasena: ");
        String contrasena = scanner.nextLine();

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

    // Método para agregar un proveedor nuevo a la lista
    public void agregarProveedor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del proveedor: ");
        String nombreProveedor = scanner.nextLine();

        System.out.print("Ingrese el contacto del proveedor: ");
        String contactoProveedor = scanner.nextLine();

        Proveedor proveedor = new Proveedor(nombreProveedor, contactoProveedor);
        proveedores.add(proveedor);
        System.out.println("Proveedor agregado: " + nombreProveedor);
    }

    // Método para agregar un producto, junto con su categoría y proveedor
    public void agregarProducto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese la cantidad en stock: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese el nombre del proveedor: ");
        String nombreProveedor = scanner.nextLine();

        System.out.print("Ingrese el contacto del proveedor: ");
        String contactoProveedor = scanner.nextLine();

        // Crear y agregar proveedor
        Proveedor proveedor = new Proveedor(nombreProveedor, contactoProveedor);
        proveedores.add(proveedor);

        // Captura de la categoría del producto
        System.out.print("Ingrese el nombre de la categoria: ");
        String nombreCategoria = scanner.nextLine();

        System.out.print("Ingrese la descripcion de la categoria: ");
        String descripcionCategoria = scanner.nextLine();

        // Crear la categoría y el producto
        Categoria categoria = new Categoria(nombreCategoria, descripcionCategoria);
        Producto producto = new Producto(nombreProducto, precio, cantidad, categoria);
        productos.add(producto);

        System.out.println("Producto agregado: " + nombreProducto);
    }

    // Método para retirar una cantidad de un producto específico
    public void retirarProducto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del producto a retirar: ");
        String nombreProducto = scanner.nextLine();

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

    // Método para listar todos los productos, con alerta si el stock está bajo
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n--- Listado de Productos ---");
            for (Producto producto : productos) {
                producto.mostrarProducto();

                // Alerta si el stock es bajo
                if (producto.getStock() < 5) {
                    System.out.println("¡ALERTA! Stock bajo.");
                }

                System.out.println("------------------------");
            }
        }
    }

    // Método para mostrar solo los productos con stock bajo
    public void mostrarAlertasStockBajo() {
        System.out.println("\n--- Alertas de Stock Bajo ---");
        for (Producto producto : productos) {
            if (producto.getStock() < 21) {
                producto.mostrarProducto();
                System.out.println("¡ALERTA! Stock bajo.");
                System.out.println("------------------------");
            }
        }
    }

    // Método para listar todos los proveedores registrados
    public void listarProveedores() {
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            System.out.println("\n--- Listado de Proveedores ---");
            for (Proveedor proveedor : proveedores) {
                proveedor.mostrarProveedor();
            }
        }
    }

    // Método para mostrar la información del usuario que inició sesión
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
