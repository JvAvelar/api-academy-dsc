package vitoravelar.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitoravelar.academy.dto.UserDTO;
import vitoravelar.academy.dto.UserUpdateDTO;
import vitoravelar.academy.model.User;
import vitoravelar.academy.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(User::toDTO).toList();
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return user.toDTO();
    }

    public Boolean exists(Long id) {
        return userRepository.existsById(id);
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"))
                .toDTO();
    }

    public UserDTO getUserByName(String name) {
        return userRepository.findByName(name).toDTO();
    }

    public UserDTO updateUser(Long id, UserUpdateDTO user) {
        User oldUser = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found"));

        oldUser.setName(user.getName());
        oldUser.setPaymentDate(user.getPaymentDate());
        userRepository.save(oldUser);
        return oldUser.toDTO();
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
