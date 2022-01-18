package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.RedSocial;
import ar.edu.unnoba.poo2021.Fiscalia.repository.RedSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedSocialServiceImpl implements RedSocialService {
    @Autowired
    private RedSocialRepository repository;

    @Override
    public RedSocial create(RedSocial redSocial) {
        if (repository.findByPerfil(redSocial.getPerfil())==null)
            redSocial = repository.save(redSocial);
        return redSocial;
    }

    @Override
    public RedSocial getRedSocial(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
