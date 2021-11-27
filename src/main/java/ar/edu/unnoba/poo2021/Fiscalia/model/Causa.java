package ar.edu.unnoba.poo2021.Fiscalia.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Causas")
public class Causa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="numero" )
    private String numero;
    @Column(name ="fecha" )
    private Date fecha;
    @Column(name = "victima")
    private String victima;
    @Column(name ="victimario" )
    private String victimario;
    @Column(name ="descripcion")
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getVictima() {
        return victima;
    }

    public void setVictima(String victima) {
        this.victima = victima;
    }

    public String getVictimario() {
        return victimario;
    }

    public void setVictimario(String victimario) {
        this.victimario = victimario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
