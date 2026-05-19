package daw;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import controladores.VeterinarioDAO;
import modelos.VeterinarioDTO;

public class MainDePruebas {
    public static void main(String[] args) throws SQLException {

        VeterinarioDAO daoVeterinario = new VeterinarioDAO();
        List<VeterinarioDTO> listaVeterinarios = new ArrayList<>();

        listaVeterinarios = daoVeterinario.getAll();
        listaVeterinarios.forEach(System.out::println);

        VeterinarioDTO veterinarioNuevo = new VeterinarioDTO(1, "11115599H", "Mew", "Calle calle", "151155115",
                "mew@gmail.com");
        daoVeterinario.updateVeterinario(1, veterinarioNuevo);

        System.out.println("-----------------------------");
        listaVeterinarios = daoVeterinario.getAll();
        listaVeterinarios.forEach(System.out::println);

    }
}