package de.htw_berlin.myshoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
    public Optional<User> getById(String id) {
        return userRepository.findById(id);
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
