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
        // obtener conexión a la BD
        con = Conexion.getInstance();
    }

    @Override
    public List<MascotaDTO> getAll() throws SQLException {

        // lista donde guardo mascotas
        List<MascotaDTO> lista = new ArrayList<>();

        // crear statement
        try (Statement st = con.createStatement()) {

            // ejecutar consulta
            ResultSet res = st.executeQuery("select * from mascota");

            // recorrer resultados
            while (res.next()) {

                MascotaDTO mascota = new MascotaDTO();

                // id
                mascota.setId_mascota(res.getInt("id_mascota"));

                // chip (puede ser null)
                int chip = res.getInt("numchip");
                mascota.setNumchip(res.wasNull() ? null : chip);

                // nombre
                mascota.setNommasc(res.getString("nommasc"));

                // peso (puede ser null)
                double peso = res.getDouble("peso");
                mascota.setPeso(res.wasNull() ? null : peso);

                // fecha (puede ser null)
                java.sql.Date fechaSQL = res.getDate("fecnacim");
                mascota.setFecnacim(fechaSQL != null ? fechaSQL.toLocalDate() : null);

                // tipo
                mascota.setTipo(res.getString("tipo"));

                // id veterinario (puede ser null)
                int idVet = res.getInt("id_veterinario");
                mascota.setId_veterinario(res.wasNull() ? null : idVet);

                // añadir a lista
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

            // pasar parámetro
            prest.setInt(1, id_mascota);

            res = prest.executeQuery();

            if (res.next()) {

                mascota.setId_mascota(res.getInt("id_mascota"));

                // chip puede ser null
                int chip = res.getInt("numchip");
                mascota.setNumchip(res.wasNull() ? null : chip);

                mascota.setNommasc(res.getString("nommasc"));

                // peso puede ser null
                double peso = res.getDouble("peso");
                mascota.setPeso(res.wasNull() ? null : peso);

                // fecha puede ser null
                java.sql.Date fechaSQL = res.getDate("fecnacim");
                mascota.setFecnacim(fechaSQL != null ? fechaSQL.toLocalDate() : null);

                mascota.setTipo(res.getString("tipo"));

                // id veterinario puede ser null
                int idVet = res.getInt("id_veterinario");
                mascota.setId_veterinario(res.wasNull() ? null : idVet);

                return mascota;
            }

            return null;
        }
    }

    @Override
    public List<MascotaDTO> mascotasDeUnVeterinario(int id_veterinario) throws SQLException {

        List<MascotaDTO> lista = new ArrayList<>();

        String sql = "select * from mascota where id_veterinario = ?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, id_veterinario);

            ResultSet res = prest.executeQuery();

            while (res.next()) {

                MascotaDTO mascota = new MascotaDTO();

                mascota.setId_mascota(res.getInt("id_mascota"));

                int chip = res.getInt("numchip");
                mascota.setNumchip(res.wasNull() ? null : chip);

                mascota.setNommasc(res.getString("nommasc"));

                double peso = res.getDouble("peso");
                mascota.setPeso(res.wasNull() ? null : peso);

                // fecha null control
                java.sql.Date fechaSQL = res.getDate("fecnacim");
                mascota.setFecnacim(fechaSQL != null ? fechaSQL.toLocalDate() : null);

                mascota.setTipo(res.getString("tipo"));

                int idVet = res.getInt("id_veterinario");
                mascota.setId_veterinario(res.wasNull() ? null : idVet);

                lista.add(mascota);
            }
        }

        return lista;
    }

    @Override
    public int insertMascota(MascotaDTO mascota) throws SQLException {

        int numFilas = 0;

        String sql = "insert into mascota values (?,?,?,?,?,?,?)";

        // comprobar si ya existe
        if (findByPk(mascota.getId_mascota()) != null) {
            return numFilas;
        } else {

            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // id
                prest.setInt(1, mascota.getId_mascota());

                // chip null control
                if (mascota.getNumchip() == null) {
                    prest.setNull(2, java.sql.Types.INTEGER);
                } else {
                    prest.setInt(2, mascota.getNumchip());
                }

                // nombre
                prest.setString(3, mascota.getNommasc());

                // peso null control
                if (mascota.getPeso() == null) {
                    prest.setNull(4, java.sql.Types.DOUBLE);
                } else {
                    prest.setDouble(4, mascota.getPeso());
                }

                // fecha null control
                if (mascota.getFecnacim() == null) {
                    prest.setNull(5, java.sql.Types.DATE);
                } else {
                    prest.setDate(5, java.sql.Date.valueOf(mascota.getFecnacim()));
                }

                // tipo
                prest.setString(6, mascota.getTipo());

                // veterinario null control
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

        String sql = "update mascota set numchip = ?, nommasc = ?, peso = ?, fecnacim = ?, tipo = ?, id_veterinario = ? where id_mascota = ?";

        // comprobar que existe
        if (findByPk(id_mascota) == null) {
            return numFilas;
        } else {

            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // chip
                if (nuevosDatos.getNumchip() == null) {
                    prest.setNull(1, java.sql.Types.INTEGER);
                } else {
                    prest.setInt(1, nuevosDatos.getNumchip());
                }

                // nombre
                prest.setString(2, nuevosDatos.getNommasc());

                // peso
                if (nuevosDatos.getPeso() == null) {
                    prest.setNull(3, java.sql.Types.DOUBLE);
                } else {
                    prest.setDouble(3, nuevosDatos.getPeso());
                }

                // fecha
                if (nuevosDatos.getFecnacim() == null) {
                    prest.setNull(4, java.sql.Types.DATE);
                } else {
                    prest.setDate(4, java.sql.Date.valueOf(nuevosDatos.getFecnacim()));
                }

                // tipo
                prest.setString(5, nuevosDatos.getTipo());

                // veterinario
                if (nuevosDatos.getId_veterinario() == null) {
                    prest.setNull(6, java.sql.Types.INTEGER);
                } else {
                    prest.setInt(6, nuevosDatos.getId_veterinario());
                }

                // id where
                prest.setInt(7, id_mascota);

                numFilas = prest.executeUpdate();
            }

            return numFilas;
        }
    }
}