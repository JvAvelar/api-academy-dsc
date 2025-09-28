package vitoravelar.academy.service;

import org.springframework.stereotype.Service;
import vitoravelar.academy.dto.EquipmentDTO;
import vitoravelar.academy.dto.EquipmentUpdateDTO;
import vitoravelar.academy.exception.ResourceNotFoundException;
import vitoravelar.academy.models.Equipment;
import vitoravelar.academy.repository.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }

    public List<EquipmentDTO> getAllEquipment(){
        return equipmentRepository.findAll().stream().map(Equipment::toDTO).toList();
    }

    public EquipmentDTO addEquipment(EquipmentDTO equipmentDTO){
        Equipment equipment = new Equipment(equipmentDTO);
        equipmentRepository.save(equipment);
        return equipment.toDTO();
    }

    public EquipmentDTO getEquipmentById(Long id){
        return equipmentRepository.findById(id)
                .map(Equipment::toDTO)
                .orElseThrow(() ->
                new ResourceNotFoundException("Equipment not found with id: " + id));
    }

    public EquipmentDTO getEquipmentByName(String name){
        return equipmentRepository.findByName(name)
                .map(Equipment::toDTO)
                .orElseThrow(() ->
                new ResourceNotFoundException("Equipment not found with name: " + name));
    }

    public EquipmentDTO updateEquipment(Long id, EquipmentUpdateDTO equipment){
        Equipment oldEquipment = equipmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Equipment not found with id: " + id));

        oldEquipment.setName(equipment.getName());
        oldEquipment.setQuantity(equipment.getQuantity());
        equipmentRepository.save(oldEquipment);
        return oldEquipment.toDTO();
    }


    public void deleteEquipment(Long id){
        Equipment equipment = equipmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Equipment not found with id: " + id));
        equipmentRepository.delete(equipment);
    }
}
