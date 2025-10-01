package vitoravelar.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitoravelar.academy.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String cpf);
    Optional<User> findByUsername(String username);
}
