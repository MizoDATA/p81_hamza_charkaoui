package modelos;

import java.time.LocalDate;

public class MascotaDTO {


    private int id_mascota;
    private int numchip;
    private String nommasc;
    private double peso;
    private LocalDate fecnacim;
    private Tipos tipo;
    private int id_veterinario;
    
    public MascotaDTO(int id_mascota, int numchip, String nommasc, double peso, LocalDate fecnacim, Tipos tipo,
            int id_veterinario) {
        this.id_mascota = id_mascota;
        this.numchip = numchip;
        this.nommasc = nommasc;
        this.peso = peso;
        this.fecnacim = fecnacim;
        this.tipo = tipo;
        this.id_veterinario = id_veterinario;
    }

    public MascotaDTO() {
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public int getNumchip() {
        return numchip;
    }

    public void setNumchip(int numchip) {
        this.numchip = numchip;
    }

    public String getNommasc() {
        return nommasc;
    }

    public void setNommasc(String nommasc) {
        this.nommasc = nommasc;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getFecnacim() {
        return fecnacim;
    }

    public void setFecnacim(LocalDate fecnacim) {
        this.fecnacim = fecnacim;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    @Override
    public String toString() {
        return "MascotaDTO [id_mascota=" + id_mascota + ", numchip=" + numchip + ", nommasc=" + nommasc + ", peso="
                + peso + ", fecnacim=" + fecnacim + ", tipo=" + tipo + ", id_veterinario=" + id_veterinario + "]";
    }

    


}
