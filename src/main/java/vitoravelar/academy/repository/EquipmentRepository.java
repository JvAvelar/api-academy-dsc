package vitoravelar.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitoravelar.academy.models.Equipment;

import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    Optional<Equipment> findByName(String name);
}
