package ar.edu.unnoba.poo2021.Fiscalia.service;


import ar.edu.unnoba.poo2021.Fiscalia.model.User;

import java.util.List;

public interface UserService {
    public User create(User user);
    public User update(User user);
    public User getUser(Long id);
    public void delete (User sessionUser, Long id)throws Exception;
    public List<User> getUsers();
}
