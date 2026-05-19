package modelos;

import java.sql.SQLException;
import java.util.List;

public interface IVeterinario {

     // Método para obtener todos los registros de la tabla
    List<VeterinarioDTO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    VeterinarioDTO findByPk(int pk) throws SQLException;
    
    // Método para insertar un registro
    int insertVeterinario (VeterinarioDTO persona) throws SQLException;
    
    // Método para insertar varios registros
    int insertVeterinarios (List<VeterinarioDTO> lista) throws SQLException;
    
    // Método para borrar una persona
    int deleteVeterinario (VeterinarioDTO p) throws SQLException;
    
    // Método para borrar toda la tabla
    int deleteVeterinarios() throws SQLException;
    
    // Método para modificar una persona. Se modifica a la persona que tenga esa 'pk'
    // con los nuevos datos que traiga la persona 'nuevosDatos'
    int updateVeterinario (int pk, VeterinarioDTO nuevosDatos) throws SQLException;

}
