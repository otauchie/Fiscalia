package ar.edu.unnoba.poo2021.Fiscalia.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Informacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String DireccionIP;
    private Date FechaHora;
    @ManyToOne
    @JoinColumn(name = "causa_id")
    private Causa causa;

    private String descripcion;

    public Causa getCausa() {
        return causa;
    }

    public void setCausa(Causa causa) {
        this.causa = causa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

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
