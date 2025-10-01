package vitoravelar.academy.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vitoravelar.academy.dto.UserDTO;
import vitoravelar.academy.dto.UserUpdateDTO;
import vitoravelar.academy.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/name/{name}")
    public UserDTO getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/id/{id}")
    public UserDTO getUserById(@PathVariable @Min(1) Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO addUser(@Valid @RequestBody UserDTO user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable @Min(1) Long id, @Valid @RequestBody UserUpdateDTO user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable @Min(1) Long id){
        userService.deleteUser(id);
    }
}
