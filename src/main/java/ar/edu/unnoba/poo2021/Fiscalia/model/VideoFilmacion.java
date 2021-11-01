package ar.edu.unnoba.poo2021.Fiscalia.model;

import java.util.Date;

public class VideoFilmacion extends Informacion{
    private Date fechaHoraFin;
    private String ubicacionFisica;
    private String data;


    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(String ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
