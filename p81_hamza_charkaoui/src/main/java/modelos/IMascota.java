package modelos;

import java.sql.SQLException;
import java.util.List;

public interface IMascota {

     // Método para obtener todos los registros de la tabla
    List<MascotaDTO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    MascotaDTO findByPk(int id_mascota) throws SQLException;

    //  Método  que permite obtener todas las mascotas tratadas por un veterinario, según su id.
    List<MascotaDTO> mascotasDeUnVeterinario(int id_veterinario) throws SQLException;
    
    // Método para insertar un registro
    int insertMascota (MascotaDTO mascota) throws SQLException;
    
    // Método para borrar una mascota
    int deleteMascota (MascotaDTO mascota) throws SQLException;
    
    // Método para modificar una mascota. Se modifica a la mascota que tenga esa 'pk'
    // con los nuevos datos que traiga la mascota 'nuevosDatos'
    int updateMascota (int id_mascota, MascotaDTO nuevosDatos) throws SQLException;

    

    
} 
