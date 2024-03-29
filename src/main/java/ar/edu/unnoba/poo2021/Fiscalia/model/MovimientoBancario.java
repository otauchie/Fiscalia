package ar.edu.unnoba.poo2021.Fiscalia.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Movimiento_Bancario")
public class MovimientoBancario extends Informacion{
    private String cuenta;
    private String usuario;
    private String tipoTransaccion;
    private Double monto;
    private String moneda;
    private String datosCajero;

    //inicializo los atributos que definen q tipo de informacion es, en este caso esMovimiento sera true
    public MovimientoBancario() {
        this.setEsLlamada(false);
        this.setEsMovimiento(true);
        this.setEsRedSocial(false);
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getDatosCajero() {
        return datosCajero;
    }

    public void setDatosCajero(String datosCajero) {
        this.datosCajero = datosCajero;
    }
}
