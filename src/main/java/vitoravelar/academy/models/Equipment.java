package vitoravelar.academy.models;

import jakarta.persistence.*;
import lombok.*;
import vitoravelar.academy.dto.EquipmentDTO;

import java.util.Objects;

@Entity
@Table(name = "tb_equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    public Equipment(){}

    public Equipment(EquipmentDTO equipmentDTO ){
        this.name = equipmentDTO.getName();
        this.quantity = equipmentDTO.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(id, equipment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public EquipmentDTO toDTO(){
        return new EquipmentDTO(id, name, quantity);
    }
}
