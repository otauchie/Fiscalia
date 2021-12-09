package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.LlamadaTelefonica;

public interface LlamadaTelefonicaService {
    public LlamadaTelefonica create(LlamadaTelefonica llamadaTelefonica );
    public LlamadaTelefonica getLlamadaTelefonica(Long id);
}
