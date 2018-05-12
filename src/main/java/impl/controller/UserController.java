package impl.controller;

import impl.db.UserRepository;
import impl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/authenticate")
    public @ResponseBody User authenticate(@RequestParam String name, @RequestParam String password) {
        return null;
    }

    @PostMapping(path="/delete")
    public void deleteUser(@RequestParam int userId) {
        userRepository.deleteById(userId);
    }
}
