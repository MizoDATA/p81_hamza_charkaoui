package controladores;

import java.sql.Connection;
import java.sql.Date;
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

                java.sql.Date fechaSQL = res.getDate("fecnacim");

                if (fechaSQL != null) {
                    mascota.setFecnacim(fechaSQL.toLocalDate());
                } else {
                    mascota.setFecnacim(null);
                }

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

        // lo mismo que arriba pero where id_veterinario xd
        List<MascotaDTO> lista = new ArrayList<>();

        String sql = "select * from mascota where id_veterinario = ?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, id_veterinario);

            ResultSet res = prest.executeQuery();

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
    public int insertMascota(MascotaDTO mascota) throws SQLException {
        int numFilas = 0;
        String sql = "insert into mascota values (?,?,?,?,?,?,?)";

        if (findByPk(mascota.getId_mascota()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, mascota.getId_mascota());
                if (mascota.getNumchip() == null) {
                    prest.setNull(2, java.sql.Types.INTEGER);
                } else {
                    prest.setInt(2, mascota.getNumchip());
                }
                prest.setString(3, mascota.getNommasc());
                if (mascota.getPeso() == null) {
                    prest.setNull(4, java.sql.Types.DOUBLE);
                } else {
                    prest.setDouble(4, mascota.getPeso());
                }
                if (mascota.getFecnacim() == null) {
                    prest.setNull(5, java.sql.Types.DATE);
                } else {
                    prest.setDate(5, java.sql.Date.valueOf(mascota.getFecnacim()));
                }
                prest.setString(6, mascota.getTipo());
                if (mascota.getId_veterinario() == null) {
                    prest.setNull(7, java.sql.Types.INTEGER);
                } else {
                    prest.setInt(7, mascota.getId_veterinario());
                }

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

    @Override
    public int deleteMascota(MascotaDTO mascota) throws SQLException {

        int numFilas = 0;

        String sql = "delete from mascota where id_mascota = ?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, mascota.getId_mascota());

            numFilas = prest.executeUpdate();
        }

        return numFilas;
    }

    @Override
    public int updateMascota(int id_mascota, MascotaDTO nuevosDatos) throws SQLException {

        int numFilas = 0;

        String sql = "update mascota set numchip = ?, nommasc = ?,  peso = ?, fecnacim = ?, tipo = ?, id_veterinario = ? where id_mascota = ?";

        if (findByPk(id_mascota) == null) {

            return numFilas;

        } else {

            try (PreparedStatement prest = con.prepareStatement(sql)) {

                if (nuevosDatos.getNumchip() == null) {
                    prest.setNull(2, java.sql.Types.INTEGER);
                } else {
                    prest.setInt(2, nuevosDatos.getNumchip());
                }
                prest.setString(2, nuevosDatos.getNommasc());
                if (nuevosDatos.getPeso() == null) {
                    prest.setNull(4, java.sql.Types.DOUBLE);
                } else {
                    prest.setDouble(4, nuevosDatos.getPeso());
                }

                // Conversión LocalDate -> Date
                if (nuevosDatos.getFecnacim() == null) {
                    prest.setNull(5, java.sql.Types.DATE);
                } else {
                    prest.setDate(5, java.sql.Date.valueOf(nuevosDatos.getFecnacim()));
                }

                prest.setString(5, nuevosDatos.getTipo());
                if (nuevosDatos.getId_veterinario() == null) {
                    prest.setNull(7, java.sql.Types.INTEGER);
                } else {
                    prest.setInt(7, nuevosDatos.getId_veterinario());
                }

                prest.setInt(7, id_mascota);

                numFilas = prest.executeUpdate();
            }

            return numFilas;
        }
    }
}
