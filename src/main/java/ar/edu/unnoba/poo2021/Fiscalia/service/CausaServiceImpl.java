package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.repository.CausaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CausaServiceImpl implements CausaService{
    @Autowired
    private CausaRepository repository;

    @Override
    public Causa create(Causa causa){
        if (repository.findByNumero(causa.getNumero())==null)
            causa = repository.save(causa);
        return causa;
    }
}
