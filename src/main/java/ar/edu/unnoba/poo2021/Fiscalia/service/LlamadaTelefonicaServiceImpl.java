package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.LlamadaTelefonica;
import ar.edu.unnoba.poo2021.Fiscalia.repository.LlamadaTelefonicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LlamadaTelefonicaServiceImpl implements LlamadaTelefonicaService{
    @Autowired
    private LlamadaTelefonicaRepository repository;

    @Override
    public LlamadaTelefonica create(LlamadaTelefonica llamadaTelefonica) {
        if(repository.findByNumeroLlamada(llamadaTelefonica.getNumeroLlamada())==null)
            llamadaTelefonica = repository.save(llamadaTelefonica);
        return llamadaTelefonica;
    }
}
