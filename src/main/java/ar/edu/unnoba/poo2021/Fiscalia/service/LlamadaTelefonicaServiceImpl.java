package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.model.LlamadaTelefonica;
import ar.edu.unnoba.poo2021.Fiscalia.repository.CausaRepository;
import ar.edu.unnoba.poo2021.Fiscalia.repository.LlamadaTelefonicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LlamadaTelefonicaServiceImpl implements LlamadaTelefonicaService{
    @Autowired
    private LlamadaTelefonicaRepository repository;

    @Override
    public LlamadaTelefonica create(LlamadaTelefonica llamadaTelefonica) {
        llamadaTelefonica = repository.save(llamadaTelefonica);
        return llamadaTelefonica;
    }

    @Override
    public LlamadaTelefonica getLlamadaTelefonica(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

}
