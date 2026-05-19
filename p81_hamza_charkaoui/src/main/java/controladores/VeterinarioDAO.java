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
import modelos.IVeterinario;
import modelos.VeterinarioDTO;



public class VeterinarioDAO implements IVeterinario {

        private Connection con = null;

    public VeterinarioDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<VeterinarioDTO> getAll() throws SQLException {
        List<VeterinarioDTO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from veterinario");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                VeterinarioDTO v = new VeterinarioDTO();
                // Recogemos los datos del veterinario, guardamos en un objeto
                v.setId_veterinario(res.getInt("id_veterinario"));
                v.setNif(res.getString("nif"));
                v.setNomvete(res.getString("nomvete"));
                v.setDir(res.getString("dir"));
                v.setTelefono(res.getString("telefono"));
                v.setEmail(res.getString("email"));
                //Añadimos el objeto a la lista
                lista.add(v);
            }
        }

        return lista;
    }

    @Override
    public VeterinarioDTO findByPk(int pk) throws SQLException {

        ResultSet res = null;
        VeterinarioDTO veterinario = new VeterinarioDTO();

        String sql = "select * from veterinario where id_veterinario=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, pk);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                veterinario.setId_veterinario(res.getInt("id_veterinario"));
                veterinario.setNif(res.getString("nif"));
                veterinario.setNomvete(res.getString("nomvete"));
                veterinario.setDir(res.getString("dir"));
                veterinario.setTelefono(res.getString("telefono"));
                veterinario.setEmail(res.getString("email"));
                return veterinario;
            }

            return null;
        }
    }

    @Override
    public int insertVeterinario(VeterinarioDTO persona) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertVeterinario'");
    }

    @Override
    public int deleteVeterinario(VeterinarioDTO p) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteVeterinario'");
    }

    @Override
    public int updateVeterinario(int pk, VeterinarioDTO nuevosDatos) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateVeterinario'");
    }



}
