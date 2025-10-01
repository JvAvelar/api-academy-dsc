package vitoravelar.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitoravelar.academy.models.Academy;

import java.util.Optional;

public interface AcademyRepository extends JpaRepository<Academy, Long> {
    Optional<Academy> findByName(String name);
    Optional<Academy> findByCnpj(String cnpj);
}
