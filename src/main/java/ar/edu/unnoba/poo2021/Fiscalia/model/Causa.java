package ar.edu.unnoba.poo2021.Fiscalia.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Causas")
public class Causa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name ="numero" )
    @Pattern(regexp = "^[P]{2}+[-]+[0-9]{2}+[-]+[0-9]{2}+[-]+[0-9]{6}+[-]+[0-9]{2}+[/]+[0]{2}$",message = "el formato del codigo debe de ser de la forma 'PP-00-00-000000-00/00' ")
    private String numero;
    @NotNull
    @Column(name ="fecha" )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    @NotNull
    @Column(name = "victima")
    private String victima;
    @NotNull
    @Column(name ="victimario" )
    private String victimario;
    @NotNull
    @Column(name ="descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "causa")
    private List<Informacion>informacion;

    public Causa() {
        this.fecha=new Date();
    }

    public List<Informacion> getInformacion() {
        return informacion;
    }

    public void setInformacion(List<Informacion> informacion) {
        this.informacion = informacion;
    }

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
