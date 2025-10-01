package vitoravelar.academy.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vitoravelar.academy.dto.EquipmentDTO;
import vitoravelar.academy.dto.EquipmentUpdateDTO;
import vitoravelar.academy.service.EquipmentService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/equipment")
@Validated
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public List<EquipmentDTO> getAllEquipment(){
        return equipmentService.getAllEquipment();
    }

    @GetMapping("/id/{id}")
    public EquipmentDTO getEquipmentById(@PathVariable @Min(1) Long id){
        return equipmentService.getEquipmentById(id);
    }

    @GetMapping("/name/{name}")
    public EquipmentDTO getEquipmentByName(@PathVariable String name){
        return equipmentService.getEquipmentByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EquipmentDTO addEquipment(@Valid @RequestBody EquipmentDTO equipmentDTO){
        return equipmentService.addEquipment(equipmentDTO);
    }

    @PatchMapping("/{id}")
    public EquipmentDTO updateEquipment(@PathVariable @Min(1) Long id, @Valid @RequestBody EquipmentUpdateDTO equipmentDTO){
        return equipmentService.updateEquipment(id, equipmentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEquipment(@PathVariable @Min(1) Long id){
        equipmentService.deleteEquipment(id);
    }
}
