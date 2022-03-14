package ar.edu.unnoba.poo2021.Fiscalia.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Red_Social")
public class RedSocial extends Informacion{
    private String tipo;
    private String perfil;

    //inicializo los atributos que definen q tipo de informacion es, en este caso esRedSocial sera true
    public RedSocial() {
        this.setEsLlamada(false);
        this.setEsMovimiento(false);
        this.setEsRedSocial(true);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
