package ar.edu.unnoba.poo2021.Fiscalia.service;

import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import ar.edu.unnoba.poo2021.Fiscalia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {
        if(repository.findByEmail(user.getUsername())==null)
            //encripta la contraseña
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            //guarda el usuario
            user = repository.save(user);


        return user  ;
    }



    @Override
    public User update(User user) {
        User uDB = repository.findById(user.getId()).get();
        uDB.setNombre(user.getNombre());
    uDB.setApellido(user.getApellido());;
        return repository.save(uDB);
    }

    @Override
    public User getUser(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(User sessionUser, Long id) throws Exception {
        if(sessionUser.getId().equals(id)){
            throw new Exception("Un usuario no se puede borrar a si mismo");
        }
        repository.deleteById(id);

    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email);
    }
}
