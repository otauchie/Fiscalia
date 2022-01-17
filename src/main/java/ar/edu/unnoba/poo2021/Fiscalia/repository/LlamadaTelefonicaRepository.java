package ar.edu.unnoba.poo2021.Fiscalia.repository;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.model.LlamadaTelefonica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LlamadaTelefonicaRepository extends JpaRepository<LlamadaTelefonica,Long> {
    public LlamadaTelefonica findByNumeroLlamada(String numeroLlamada);


}
