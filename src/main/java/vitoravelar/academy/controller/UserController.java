package vitoravelar.academy.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import vitoravelar.academy.dto.UserDTO;
import vitoravelar.academy.dto.UserUpdateDTO;
import vitoravelar.academy.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/academy")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{cpf}")
    public UserDTO getUserByCpf(@PathVariable String cpf) {
        return Optional.ofNullable(userService.getUserByCpf(cpf))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> getUserById(@PathVariable Long id) {
        return Optional.ofNullable(userService.getUserById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO addUser(@RequestBody UserDTO user) {
        return userService.addUser(user);
    }

    @PatchMapping
    public UserDTO updateUser(@PathVariable String cpf, @RequestBody UserUpdateDTO user) {
        return Optional.ofNullable(userService.updateUser(cpf, user))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String cpf){
        userService.deleteUser(cpf);
    }
}
