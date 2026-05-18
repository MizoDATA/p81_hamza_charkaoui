package modelos;

public class VeterinarioDTO {

    private int id_veterinario;
    private String nif;
    private String nomvete;
    private String dir;
    private String telefono;
    private String email;
    
    public VeterinarioDTO(int id_veterinario, String nif, String nomvete, String dir, String telefono, String email) {
        this.id_veterinario = id_veterinario;
        this.nif = nif;
        this.nomvete = nomvete;
        this.dir = dir;
        this.telefono = telefono;
        this.email = email;
    }

    public VeterinarioDTO() {
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNomvete() {
        return nomvete;
    }

    public void setNomvete(String nomvete) {
        this.nomvete = nomvete;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "VeterinarioDTO [id_veterinario=" + id_veterinario + ", nif=" + nif + ", nomvete=" + nomvete + ", dir="
                + dir + ", telefono=" + telefono + ", email=" + email + "]";
    }

    

}
