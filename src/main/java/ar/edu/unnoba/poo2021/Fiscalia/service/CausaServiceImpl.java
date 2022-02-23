package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import ar.edu.unnoba.poo2021.Fiscalia.repository.CausaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Causa update(Causa causa) {
        Causa cDB = repository.findById(causa.getId()).get();
        cDB.setDescripcion(causa.getDescripcion());
        cDB.setEstado(causa.getEstado());
        return repository.save(cDB);
    }

    @Override
    public Causa getCausa(Long id) {
        return  repository.findById(id).get();
    }

    public List<Causa> getCausas() {
        return repository.findAll();
    }

    public List<Causa> causasPorFecha(){ return repository.ordenarCausas();}

    @Override
    public List<Causa> buscarEnCausas(String keyword) {
        return repository.buscarCausas(keyword);
    }
}
