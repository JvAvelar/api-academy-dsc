package vitoravelar.academy.models;

import jakarta.persistence.*;
import lombok.*;
import vitoravelar.academy.dto.EquipmentDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
    @Column(name = "academy", nullable = false)
    private Academy academy;

    public Equipment(EquipmentDTO equipmentDTO ){
        this.id = equipmentDTO.getId();
        this.name = equipmentDTO.getName();
        this.quantity = equipmentDTO.getQuantity();
    }

    public EquipmentDTO toDTO(){
        return new EquipmentDTO(id, name, quantity);
    }
}
