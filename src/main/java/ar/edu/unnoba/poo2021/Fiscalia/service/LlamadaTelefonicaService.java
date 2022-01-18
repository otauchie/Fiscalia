package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.LlamadaTelefonica;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;

public interface LlamadaTelefonicaService {
    public LlamadaTelefonica create(LlamadaTelefonica llamadaTelefonica );
    public LlamadaTelefonica getLlamadaTelefonica(Long id);
    //public LlamadaTelefonica update(LlamadaTelefonica llamadaTelefonica);
    public void delete (Long id);
}
