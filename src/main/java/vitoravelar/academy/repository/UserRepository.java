package vitoravelar.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitoravelar.academy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String cpf);
}
