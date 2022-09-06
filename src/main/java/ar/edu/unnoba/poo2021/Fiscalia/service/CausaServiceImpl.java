package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.model.Informacion;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import ar.edu.unnoba.poo2021.Fiscalia.repository.CausaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CausaServiceImpl implements CausaService{
    @Autowired
    private CausaRepository repository;

    @Override
    public Causa create(Causa causa){
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

    @Override
    public List<Informacion> listaOrdenada(Causa causa) {

        Causa cBD=repository.findById(causa.getId()).get();
        List <Informacion> aux=new ArrayList<>();
        if (cBD.getInformacion().size()==0){
            return aux;
        }else{
            Informacion infoMin= cBD.getInformacion().get(0);
            Informacion infoMax= cBD.getInformacion().get(0);
            Informacion puntero= cBD.getInformacion().get(0);

            for(Informacion x: cBD.getInformacion()){

                if (x.getFechaHora().before(infoMin.getFechaHora())){
                    infoMin=x;
                }
                if (x.getFechaHora().after(infoMax.getFechaHora())){
                    infoMax=x;
                    puntero=x;

                }
            }
            aux.add(infoMin);
            while(puntero.getFechaHora().after(infoMin.getFechaHora())){

                for(Informacion x: cBD.getInformacion()){
                    if(x.getFechaHora().before(puntero.getFechaHora()) && x.getFechaHora().after(infoMin.getFechaHora())){
                        puntero=x;

                    }

                }
                aux.add(puntero);
                infoMin=puntero;
                puntero=infoMax;


            }
            return aux;
        }


    }

}
