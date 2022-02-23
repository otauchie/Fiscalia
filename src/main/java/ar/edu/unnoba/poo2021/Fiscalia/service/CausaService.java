package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;

import java.util.List;

public interface CausaService {
    public Causa create(Causa causa);
    public Causa update(Causa causa);
    public Causa getCausa(Long id);
    public List<Causa> getCausas();
    public List<Causa> causasPorFecha();
    public List<Causa> buscarEnCausas(String keyword);
}
