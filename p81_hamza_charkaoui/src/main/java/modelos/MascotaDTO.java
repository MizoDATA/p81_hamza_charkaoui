package modelos;

import java.time.LocalDate;

public class MascotaDTO {


    private int id_mascota;
    private Integer numchip;
    private String nommasc;
    private Double peso;
    private LocalDate fecnacim;
    private String tipo;
    private Integer id_veterinario;
    
    public MascotaDTO(int id_mascota, Integer numchip, String nommasc, Double peso, LocalDate fecnacim, String tipo,
            Integer id_veterinario) {
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

    public Integer getNumchip() {
        return numchip;
    }

    public void setNumchip(Integer numchip) {
        this.numchip = numchip;
    }

    public String getNommasc() {
        return nommasc;
    }

    public void setNommasc(String nommasc) {
        this.nommasc = nommasc;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public LocalDate getFecnacim() {
        return fecnacim;
    }

    public void setFecnacim(LocalDate fecnacim) {
        this.fecnacim = fecnacim;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getId_veterinario() {
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
