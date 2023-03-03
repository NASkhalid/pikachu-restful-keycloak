package org.sid.pokemonservice.service.impl;

import org.sid.pokemonservice.entity.User;
import org.sid.pokemonservice.repository.UserRepository;
import org.sid.pokemonservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByCredential(String login, String password) {
        return userRepository.findByLoginAndPassword(login,password);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userFound = userRepository.findById(id).get();
        if(userFound != null && user != null) {
            userFound.setFirstName(user.getFirstName());
            userFound.setLastName(user.getLastName());
            userFound.setLogin(user.getLogin());
            userFound.setPassword(user.getPassword());

            userRepository.save(userFound);
        }

        return userFound;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
