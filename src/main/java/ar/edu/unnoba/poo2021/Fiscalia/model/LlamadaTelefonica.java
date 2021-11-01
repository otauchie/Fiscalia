package ar.edu.unnoba.poo2021.Fiscalia.model;

public class LlamadaTelefonica extends Informacion {
    private String numeroLlamada;
    private String numeroReceptor;
    private long duracion;

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

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }
}
