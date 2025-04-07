package com.mycompany.gestorinventario;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear instancia del gestor de inventario
        GestorInventario gestor = new GestorInventario();

        // Iniciar sesion del usuario
        gestor.iniciarSesion();

        // Crear un objeto Scanner para manejar las entradas
        Scanner scanner = new Scanner(System.in);

        // Bandera para salir del menu
        boolean salir = false;

        // Menu interactivo
        while (!salir) {
            // Mostrar opciones del menu
            System.out.println("\n--- Menu ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Retirar Producto");
            System.out.println("3. Listar Producto");
            System.out.println("4. Alertas de stock bajo");
            System.out.println("5. Listar Proveedores");
            System.out.println("6. Mostrar Usuario Activo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de la entrada

            // Acciones segun la opcion seleccionada
            switch (opcion) {
                case 1:
                    gestor.agregarProducto();
                    break;
                case 2:
                    gestor.retirarProducto();
                    break;
                case 3:
                    gestor.listarProductos();
                    break;
                case 4:
                    gestor.mostrarAlertasStockBajo();
                    break;
                case 5:
                    gestor.listarProveedores();
                    break;
                case 6:
                    gestor.mostrarUsuarioActivo();
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
        }

        // Cerrar el scanner
        scanner.close();
    }
}
