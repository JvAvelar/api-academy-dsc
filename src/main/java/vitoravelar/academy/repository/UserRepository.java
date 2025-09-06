package vitoravelar.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitoravelar.academy.dto.UserDTO;

public interface UserRepository extends JpaRepository<UserDTO, Long> {
    UserDTO findByCpf(String cpf);
}
