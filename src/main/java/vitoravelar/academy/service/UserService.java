package vitoravelar.academy.service;

import org.springframework.stereotype.Service;
import vitoravelar.academy.dto.UserDTO;
import vitoravelar.academy.dto.UserUpdateDTO;
import vitoravelar.academy.exceptions.ResourceNotFoundException;
import vitoravelar.academy.models.User;
import vitoravelar.academy.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(User::toDTO).toList();
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
        return user.toDTO();
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map( User::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public UserDTO getUserByName(String name) {
        return userRepository.findByName(name)
                .map( User::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with name: " + name));
    }

    public UserDTO updateUser(Long id, UserUpdateDTO user) {
        User oldUser = userRepository.findById(id)
                .orElseThrow(() ->
                new ResourceNotFoundException("User not found with id: " + id));

        oldUser.setName(user.getName());
        oldUser.setPaymentDate(user.getPaymentDate());
        userRepository.save(oldUser);
        return oldUser.toDTO();
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }
}
