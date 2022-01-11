package ar.edu.unnoba.poo2021.Fiscalia.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Llamada_Telefonica")
public class LlamadaTelefonica extends Informacion {

    private String numeroLlamada;
    private String numeroReceptor;
    private Integer duracion;

    public LlamadaTelefonica() {
        this.setEsLlamada(true);
        this.setEsMovimiento(false);
        this.setEsRedSocial(false);
    }

    public String getNumeroLlamada() {
        return numeroLlamada;
    }

    public void setNumeroLlamada(String numeroLlamada) {
        this.numeroLlamada = numeroLlamada;
    }

    public String getNumeroReceptor() {
        return numeroReceptor;
    }

    public void setNumeroReceptor(String numeroReceptor) {
        this.numeroReceptor = numeroReceptor;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
}
