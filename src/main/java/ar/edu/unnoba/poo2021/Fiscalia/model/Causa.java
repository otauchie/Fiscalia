package ar.edu.unnoba.poo2021.Fiscalia.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Causas")
public class Causa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_expediente")
    private String numeroExpediente;

    @Column(name = "juzgado")
    private String juzgado;



    @ManyToMany
    @JoinTable(name = "informacion_causas",
    joinColumns=@JoinColumn(name = "causa_id"),
    inverseJoinColumns = @JoinColumn(name = "informacion_id"))
    private List<Informacion> informaciones;

    @Column(name = "contexto")
    private String contexto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getJuzgado() {
        return juzgado;
    }

    public void setJuzgado(String juzgado) {
        this.juzgado = juzgado;
    }



    public List<Informacion> getInformaciones() {
        return informaciones;
    }

    public void setInformaciones(List<Informacion> informaciones) {
        this.informaciones = informaciones;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }
}
