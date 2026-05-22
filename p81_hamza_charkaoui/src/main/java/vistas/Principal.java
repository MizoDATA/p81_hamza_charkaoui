package vistas;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

   
    // SCANNER
   
    static Scanner sc = new Scanner(System.in);

   
    // MENÚS
    
    static final String MENU_PRINCIPAL = """
            ========= MENÚ PRINCIPAL =========
            1. Operaciones con Mascotas
            2. Operaciones con Veterinarios
            0. Salir
            """;

    static final String MENU_MASCOTAS = """
            ========= MENÚ MASCOTAS =========
            1. Mostrar mascotas
            2. Buscar mascota
            3. Insertar mascota
            4. Modificar mascota
            5. Borrar mascota
            6. Mostrar mascotas de un veterinario
            7. Asignar veterinario a mascota
            0. Volver
            """;

    static final String MENU_VETERINARIOS = """
            ========= MENÚ VETERINARIOS =========
            1. Mostrar veterinarios
            2. Buscar veterinario
            3. Insertar veterinario
            4. Modificar veterinario
            5. Borrar veterinario
            0. Volver
            """;

  
    // MAIN
   
    public static void main(String[] args) throws SQLException {

        int opcionPrincipal;
        int opcionSubmenu;

     
        // BUCLE MENÚ PRINCIPAL
   
        do {

            System.out.println(MENU_PRINCIPAL);

            System.out.print("Opción: ");
            opcionPrincipal = sc.nextInt();

            switch (opcionPrincipal) {

           
            // MENÚ MASCOTAS  
            case 1:

                do {

                    System.out.println(MENU_MASCOTAS);

                    System.out.print("Opción: ");
                    opcionSubmenu = sc.nextInt();

                    switch (opcionSubmenu) {

                    case 1:
                        // mostrar mascotas
                        GestionMascotas.mostrarMascotas();
                        break;

                    case 2:
                        // buscar mascotas
                        GestionMascotas.buscarMascota();
                        break;

                    case 3:
                        // insetrar mascota
                        GestionMascotas.insertarMascota();
                        break;

                    case 4:
                       // modificar mascxotas
                       GestionMascotas.modificarMascota();
                        break;

                    case 5:
                        // borrar mascota
                        GestionMascotas.borrarMascota();
                        break;

                    case 6:
                       // mascotas de un veterinario
                       GestionMascotas.mascotasDeVeterinario();
                        break;

                    case 7:
                        // asignar veterinario
                        GestionMascotas.asignarVeterinario();
                        break;

                    case 0:
                        System.out.println("Volviendo...");
                        break;

                    default:
                        System.out.println("Opción incorrecta");
                    }

                } while (opcionSubmenu != 0);

                break;

           
            // MENÚ VETERINARIOS
            case 2:

                do {

                    System.out.println(MENU_VETERINARIOS);

                    System.out.print("Opción: ");
                    opcionSubmenu = sc.nextInt();

                    switch (opcionSubmenu) {

                    case 1:
                        // mostrar veterinarios
                        GestionVeterinarios.mostrarVeterinarios();
                        break;

                    case 2:
                        // buscar veterinario
                        GestionVeterinarios.buscarVeterinario();
                        break;

                    case 3:
                        // insertar veterianrio
                        GestionVeterinarios.insertarVeterinario();
                        break;

                    case 4:
                        // modificar veterinario
                        GestionVeterinarios.modificarVeterinario();
                        break;

                    case 5:
                       // borrar veterinario
                       GestionVeterinarios.borrarVeterinario();
                        break;

                    case 0:
                        System.out.println("Volviendo...");
                        break;

                    default:
                        System.out.println("Opción incorrecta");
                    }

                } while (opcionSubmenu != 0);

                break;

            // ==================================
            // SALIR
            // ==================================
            case 0:

                System.out.println("bye bye");
                break;

            default:
                System.out.println("Opción incorrecta");
            }

        } while (opcionPrincipal != 0);

      
    }
}