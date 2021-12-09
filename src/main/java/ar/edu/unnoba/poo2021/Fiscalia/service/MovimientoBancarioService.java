package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.MovimientoBancario;

public interface MovimientoBancarioService {
    public MovimientoBancario create(MovimientoBancario movimientoBancario);
    public MovimientoBancario getMovimientoBancario(Long id);
}
