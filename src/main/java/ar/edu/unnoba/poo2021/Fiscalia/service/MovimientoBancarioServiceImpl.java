package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.MovimientoBancario;
import ar.edu.unnoba.poo2021.Fiscalia.repository.MovimientoBancarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoBancarioServiceImpl implements MovimientoBancarioService {
    @Autowired
    private MovimientoBancarioRepository repository;
    @Override
    public MovimientoBancario create(MovimientoBancario movimientoBancario) {

        if(repository.findByCuenta(movimientoBancario.getCuenta())==null)
            movimientoBancario = repository.save(movimientoBancario);
        return movimientoBancario;
    }

    @Override
    public MovimientoBancario getMovimientoBancario(Long id) {
        return repository.findById(id).get();
    }
}
