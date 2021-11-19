package ar.edu.unnoba.poo2021.Fiscalia.repository;

import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUserName(String userName);
}
