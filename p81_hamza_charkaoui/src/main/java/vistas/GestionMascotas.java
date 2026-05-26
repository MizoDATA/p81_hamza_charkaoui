package vistas;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controladores.MascotaDAO;
import controladores.VeterinarioDAO;
import modelos.MascotaDTO;

public class GestionMascotas {

    static Scanner sc = new Scanner(System.in);
    static MascotaDAO daoMascota = new MascotaDAO();

    // MOSTRAR
    public static void mostrarMascotas() throws SQLException {

        List<MascotaDTO> lista = daoMascota.getAll();

        lista.forEach(System.out::println);
    }

    // BUSCAR
    public static void buscarMascota() throws SQLException {

        System.out.print("ID mascota: ");
        int id = sc.nextInt();

        MascotaDTO mascota = daoMascota.findByPk(id);

        System.out.println(mascota);
    }

    // INSERTAR
    public static void insertarMascota() throws SQLException {

        MascotaDTO mascota = leerMascota();

        daoMascota.insertMascota(mascota);

        System.out.println("Mascota insertada");
    }

    // MODIFICAR
    public static void modificarMascota() throws SQLException {

        System.out.print("ID mascota a modificar: ");
        int id = sc.nextInt();

        MascotaDTO mascota = leerMascota();

        daoMascota.updateMascota(id, mascota);

        System.out.println("Mascota modificada");
    }

    // BORRAR
    public static void borrarMascota() throws SQLException {

        System.out.print("ID mascota a borrar: ");
        int id = sc.nextInt();

        MascotaDTO mascota = daoMascota.findByPk(id);

        daoMascota.deleteMascota(mascota);

        System.out.println("Mascota borrada");
    }

    // MASCOTAS DE UN VETERINARIO
    public static void mascotasDeVeterinario() throws SQLException {

        System.out.print("ID veterinario: ");
        int idVeterinario = sc.nextInt();

        List<MascotaDTO> lista = daoMascota.mascotasDeUnVeterinario(idVeterinario);

        lista.forEach(System.out::println);
    }

    // ASIGNAR VETERINARIO
    public static void asignarVeterinario() throws SQLException {

        System.out.print("ID mascota: ");
        int idMascota = sc.nextInt();

        MascotaDTO mascota = daoMascota.findByPk(idMascota);
        VeterinarioDAO daoVet = new VeterinarioDAO();

        if (mascota != null) {

            System.out.print("ID del nuevo veterinario: ");
            int idVeterinario = sc.nextInt();

            if (daoVet.getAll().contains(idVeterinario)) {

                mascota.setId_veterinario(idVeterinario);

                daoMascota.updateMascota(idMascota, mascota);

                System.out.println("Veterinario asignado");
            }else{
                System.out.println("No existe el ID de ese veterinario");
            }

        } else {

            System.out.println("No existe el ID de esa mascota");
        }
    }

    // LEER MASCOTA
    public static MascotaDTO leerMascota() {

        System.out.print("ID mascota: ");
        int id = sc.nextInt();

        System.out.print("Numchip: ");
        int numchip = sc.nextInt();

        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Peso: ");
        double peso = sc.nextDouble();

        // divido fecha en año mes y dia para luego meterlo a un localdate
        System.out.print("Año nacimiento: ");
        int anio = sc.nextInt();

        System.out.print("Mes nacimiento: ");
        int mes = sc.nextInt();

        System.out.print("Día nacimiento: ");
        int dia = sc.nextInt();

        sc.nextLine();

        System.out.print("Tipo: ");
        String tipo = sc.nextLine();

        System.out.print("ID veterinario: ");
        int idVeterinario = sc.nextInt();

        return new MascotaDTO(
                id,
                numchip,
                nombre,
                peso,
                LocalDate.of(anio, mes, dia),
                tipo,
                idVeterinario);
    }
}