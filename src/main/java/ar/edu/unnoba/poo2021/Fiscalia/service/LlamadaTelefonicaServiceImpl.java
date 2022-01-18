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

    @Override
    public LlamadaTelefonica getLlamadaTelefonica(Long id) {
        return repository.findById(id).get();
    }
/*
    @Override
    public LlamadaTelefonica update(LlamadaTelefonica llamadaTelefonica) {
        LlamadaTelefonica llamadaDB = repository.findById(llamadaTelefonica.getId()).get();
        llamadaDB.setNumeroLlamada(llamadaTelefonica.getNumeroLlamada());
        llamadaDB.setNumeroReceptor(llamadaTelefonica.getNumeroReceptor());
        llamadaDB.setDuracion(llamadaTelefonica.getDuracion());
        llamadaDB.setDescripcion(llamadaTelefonica.getDescripcion());
        llamadaDB.setFechaHora(llamadaTelefonica.getFechaHora());
        llamadaDB.setDireccionIP(llamadaTelefonica.getDireccionIP());
        return repository.save(llamadaDB);
    }
*/
    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

}
