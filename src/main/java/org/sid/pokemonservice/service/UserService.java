package org.sid.pokemonservice.service;

import org.sid.pokemonservice.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);
    User getUserByCredential(String login, String password);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
