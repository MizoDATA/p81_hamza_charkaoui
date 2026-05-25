package daw;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import controladores.MascotaDAO;
import controladores.VeterinarioDAO;
import modelos.MascotaDTO;
import modelos.VeterinarioDTO;

public class MainDePruebas {
   /* public static void main(String[] args) throws SQLException {

        VeterinarioDAO daoVeterinario = new VeterinarioDAO();
        List<VeterinarioDTO> listaVeterinarios = new ArrayList<>();

        System.out.println("-------------TODOS LOS VETERINARIOS----------------");
        listaVeterinarios = daoVeterinario.getAll();
        listaVeterinarios.forEach(System.out::println);

        VeterinarioDTO veterinarioModificado = new VeterinarioDTO(1, "11115599H", "Mew", "Calle calle", "151155115",
                "mew@gmail.com");
        daoVeterinario.updateVeterinario(1, veterinarioModificado);

        System.out.println("------------VETERINARIOS POST MODIFICACION-----------------");
        listaVeterinarios = daoVeterinario.getAll();
        listaVeterinarios.forEach(System.out::println);

        VeterinarioDTO veterinarioNuevo = new VeterinarioDTO(4, "45457812A", "Pedro", "Vive en el Gym", "",
                "");
        daoVeterinario.insertVeterinario(veterinarioNuevo);

        System.out.println("------------VETERINARIO POR ID-----------------");
        veterinarioNuevo = daoVeterinario.findByPk(4);
        System.out.println(veterinarioNuevo);

        MascotaDAO daoMascota = new MascotaDAO();
        List<MascotaDTO> listaMascotas = new ArrayList<>();

        System.out.println("-------------TODAS LAS MASCOTAS----------------");
        listaMascotas = daoMascota.getAll();
        System.out.println("Lista total - >");
        listaMascotas.forEach(System.out::println);

        System.out.println("-------------MASCOTAS DE UN VETERINARIO----------------");

        listaMascotas = daoMascota.mascotasDeUnVeterinario(1);
        System.out.println("Lista de mascotas con veterinario id = 1");
        listaMascotas.forEach(System.out::println);

        System.out.println("-------------MASCOTA NUEVA----------------");

        MascotaDTO mascotaNueva = new MascotaDTO(6, 60, "Taiga",
                8.3, LocalDate.of(2021, 3, 12), "gato", 1);
        // borrar mascota
        daoMascota.deleteMascota(mascotaNueva);
        // insertar mascota
        daoMascota.insertMascota(mascotaNueva);

        System.out.println("-------------MASCOTA MODIFICADA----------------");
       // daoMascota.updateMascota(6, mascotaNueva);

        MascotaDTO mascotaModificada = new MascotaDTO(1, 10, "Shigeno", 12.5,
                LocalDate.of(2020, 5, 10), "perro", 1);
        daoMascota.updateMascota(1, mascotaModificada);

        System.out.println("--------------MASCOTAS POST CRUD---------------");
        listaMascotas = daoMascota.getAll();
        listaMascotas.forEach(System.out::println);

    }*/
}