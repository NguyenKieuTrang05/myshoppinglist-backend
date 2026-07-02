package de.htw_berlin.myshoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userSerivce;

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userSerivce.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userSerivce.getById(id).orElseThrow();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userSerivce.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id) {
        userSerivce.delete(id);
    }

}
