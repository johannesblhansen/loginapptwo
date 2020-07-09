package dk.johannes.loginapp.controllers;

import dk.johannes.loginapp.domain.user.User;
import dk.johannes.loginapp.domain.user.UserDTO;
import dk.johannes.loginapp.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/createuser")
    public void createUser(UserDTO userdto){
        userService.createUser(userdto);
    }

    @GetMapping(path = "/user/{username}")
    public User getUser(@PathVariable String username){
        return userService.getUserByName(username);
    }

    @GetMapping(path = "/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
}
