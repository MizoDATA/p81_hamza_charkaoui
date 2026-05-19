package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import modelos.IMascota;
import modelos.MascotaDTO;

public class MascotaDAO implements IMascota {

    private Connection con = null;

    public MascotaDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<MascotaDTO> getAll() throws SQLException {
        
        List<MascotaDTO> lista = new ArrayList<>();

        try (Statement st = con.createStatement()) {

            ResultSet res = st.executeQuery("select * from mascota");

            while (res.next()) {

                MascotaDTO mascota = new MascotaDTO();

                mascota.setId_mascota(res.getInt("id_mascota"));
                mascota.setNumchip(res.getInt("numchip"));
                mascota.setNommasc(res.getString("nommasc"));
                mascota.setPeso(res.getDouble("peso"));

                // Conversión Date -> LocalDate
                mascota.setFecnacim(res.getDate("fecnacim").toLocalDate());

                mascota.setTipo(res.getString("tipo"));
                mascota.setId_veterinario(res.getInt("id_veterinario"));

                lista.add(mascota);
            }
        }

        return lista;
    }

    @Override
    public MascotaDTO findByPk(int id_mascota) throws SQLException {

         ResultSet res = null;

        MascotaDTO mascota = new MascotaDTO();

        String sql = "select * from mascota where id_mascota = ?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, id_mascota);

            res = prest.executeQuery();

            if (res.next()) {

                mascota.setId_mascota(res.getInt("id_mascota"));
                mascota.setNumchip(res.getInt("numchip"));
                mascota.setNommasc(res.getString("nommasc"));
                mascota.setPeso(res.getDouble("peso"));

                // Conversión Date -> LocalDate
                mascota.setFecnacim(res.getDate("fecnacim").toLocalDate());

                mascota.setTipo(res.getString("tipo"));
                mascota.setId_veterinario(res.getInt("id_veterinario"));

                return mascota;
            }

            return null;
        }
    }

    @Override
    public List<MascotaDTO> mascotasDeUnVeterinario(int id_veterinario) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mascotasDeUnVeterinario'");
    }

    @Override
    public int insertMascota(MascotaDTO mascota) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertMascota'");
    }

    @Override
    public int deleteMascota(MascotaDTO mascota) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteMascota'");
    }

    @Override
    public int updateMascota(int id_mascota, MascotaDTO nuevosDatos) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateMascota'");
    }

}
