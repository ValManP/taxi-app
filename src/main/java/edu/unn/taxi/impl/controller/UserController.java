package edu.unn.taxi.impl.controller;

import edu.unn.taxi.impl.db.UserRepository;
import edu.unn.taxi.impl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/authenticate")
    public @ResponseBody User authenticate(@RequestParam String name, @RequestParam String password) {
        for (User user : (Iterable<User>) userRepository.findAll()) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @GetMapping(path="/delete")
    public void deleteUser(@RequestParam int userId) {
        userRepository.deleteById(userId);
    }
}
