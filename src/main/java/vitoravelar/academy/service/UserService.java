package vitoravelar.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitoravelar.academy.dto.UserDTO;
import vitoravelar.academy.dto.UserUpdateDTO;
import vitoravelar.academy.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDTO addUser(UserDTO user) {
       return userRepository.save(user);
    }

     public Boolean exists(Long id) {
        return userRepository.existsById(id);
    }

    public Optional<UserDTO> getUserById(Long id) {
        return Optional.of(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserDTO getUserByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    public UserDTO updateUser(String cpf, UserUpdateDTO user) {
        UserDTO oldUser = userRepository.findByCpf(cpf);
        if (exists(oldUser.getId())) {
            oldUser.setCpf(user.getName());
            oldUser.setPaymentDate(user.getPaymentDate());
            return oldUser;
        } else throw new RuntimeException("User not found");
    }

    public void deleteUser(String cpf) {
        UserDTO user = userRepository.findByCpf(cpf);
        if (exists(user.getId())) {
            userRepository.delete(user);
        } else throw new RuntimeException("User not exists");
    }
}
