package ar.edu.unnoba.poo2021.Fiscalia.model;

import java.util.Date;

public abstract class Informacion {
    private Long id;
    private String DireccionIP;
    private Date FechaHora;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccionIP() {
        return DireccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        DireccionIP = direccionIP;
    }

    public Date getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        FechaHora = fechaHora;
    }
}
