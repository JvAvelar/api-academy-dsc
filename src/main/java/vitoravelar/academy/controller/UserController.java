package vitoravelar.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vitoravelar.academy.dto.UserDTO;
import vitoravelar.academy.dto.UserUpdateDTO;
import vitoravelar.academy.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/academy/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{name}")
    public UserDTO getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO addUser(@RequestBody UserDTO user) {
        return userService.addUser(user);
    }

    @PatchMapping
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
