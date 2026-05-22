package vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controladores.VeterinarioDAO;
import modelos.VeterinarioDTO;

public class GestionVeterinarios {

    static Scanner sc = new Scanner(System.in);
    static VeterinarioDAO daoVeterinario = new VeterinarioDAO();


    // MOSTRAR
    public static void mostrarVeterinarios() throws SQLException {

        List<VeterinarioDTO> lista = daoVeterinario.getAll();

        lista.forEach(System.out::println);
    }

    // BUSCAR
    public static void buscarVeterinario() throws SQLException {

        System.out.print("ID veterinario: ");
        int id = sc.nextInt();

        VeterinarioDTO veterinario = daoVeterinario.findByPk(id);

        System.out.println(veterinario);
    }


    // INSERTAR
    public static void insertarVeterinario() throws SQLException {

        VeterinarioDTO veterinario = leerVeterinario();

        daoVeterinario.insertVeterinario(veterinario);

        System.out.println("Veterinario insertado");
    }


    // MODIFICAR
    public static void modificarVeterinario() throws SQLException {

        System.out.print("ID veterinario a modificar: ");
        int id = sc.nextInt();

        VeterinarioDTO veterinario = leerVeterinario();

        daoVeterinario.updateVeterinario(id, veterinario);

        System.out.println("Veterinario modificado");
    }

   
    // BORRAR
    public static void borrarVeterinario() throws SQLException {

        System.out.print("ID veterinario a borrar: ");
        int id = sc.nextInt();

        VeterinarioDTO veterinario = daoVeterinario.findByPk(id);

        daoVeterinario.deleteVeterinario(veterinario);

        System.out.println("Veterinario borrado");
    }

    // LEER VETERINARIO
    public static VeterinarioDTO leerVeterinario() {

        System.out.print("ID veterinario: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("NIF: ");
        String nif = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        return new VeterinarioDTO(
                id,
                nif,
                nombre,
                direccion,
                telefono,
                email);
    }
}