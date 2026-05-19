package modelos;

import java.sql.SQLException;
import java.util.List;

public interface IMascota {

     // Método para obtener todos los registros de la tabla
    List<MascotaDTO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    MascotaDTO findByPk(int pk) throws SQLException;

    //  Método  que permite obtener todas las mascotas tratadas por un veterinario, según su id.
    List<MascotaDTO> mascotasDeUnVeterinario(int pk_veterinario) throws SQLException;
    
    // Método para insertar un registro
    int insertMascota (MascotaDTO persona) throws SQLException;
    
    // Método para borrar una persona
    int deleteMascota (MascotaDTO p) throws SQLException;
    
    // Método para modificar una persona. Se modifica a la persona que tenga esa 'pk'
    // con los nuevos datos que traiga la persona 'nuevosDatos'
    int updateMascota (int pk, MascotaDTO nuevosDatos) throws SQLException;

    

    
} 
