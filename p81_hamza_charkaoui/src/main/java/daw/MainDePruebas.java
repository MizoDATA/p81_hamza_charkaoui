package daw;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import controladores.MascotaDAO;
import controladores.VeterinarioDAO;
import modelos.MascotaDTO;
import modelos.VeterinarioDTO;

public class MainDePruebas {
    public static void main(String[] args) throws SQLException {

        VeterinarioDAO daoVeterinario = new VeterinarioDAO();
        List<VeterinarioDTO> listaVeterinarios = new ArrayList<>();

        listaVeterinarios = daoVeterinario.getAll();
        listaVeterinarios.forEach(System.out::println);

        VeterinarioDTO veterinarioModificado = new VeterinarioDTO(1, "11115599H", "Mew", "Calle calle", "151155115",
                "mew@gmail.com");
        daoVeterinario.updateVeterinario(1, veterinarioModificado);

        System.out.println("-----------------------------");
        listaVeterinarios = daoVeterinario.getAll();
        listaVeterinarios.forEach(System.out::println);

        VeterinarioDTO veterinarioNuevo = new VeterinarioDTO(4, "45457812A", "Pedro", "Vive en el Gym", "",
                "");
        daoVeterinario.insertVeterinario(veterinarioNuevo);

        System.out.println("-----------------------------");
        veterinarioNuevo = daoVeterinario.findByPk(4);
        System.out.println(veterinarioNuevo);

        MascotaDAO daoMascota = new MascotaDAO();
        List<MascotaDTO> listaMascotas = new ArrayList<>();

        listaMascotas = daoMascota.getAll();
        System.out.println("Lista total - >");
        listaMascotas.forEach(System.out::println);

        listaMascotas = daoMascota.mascotasDeUnVeterinario(1);
        System.out.println("Lista de mascotas con veterinario id = 1");
        listaMascotas.forEach(System.out::println);

    }
}