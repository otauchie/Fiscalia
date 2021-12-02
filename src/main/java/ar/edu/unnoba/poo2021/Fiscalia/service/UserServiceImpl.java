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
        if(repository.findByUserName(user.getUsername())==null)
            //encripta la contraseña
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            //guarda el usuario
            user = repository.save(user);


        return user  ;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User getUser(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(User sessionUser, Long id) throws Exception {

    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return repository.findByUserName(userName);
    }
}
