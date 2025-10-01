package vitoravelar.academy.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EquipmentDTO {

    @NotNull(message = "O id do equipamento não pode ser null")
    @Min(value = 1, message = "O id não pode ser menor que 1")
    private Long id;

    @NotBlank(message = "O nome do equipamento não pode estar vazio")
    @Size(min = 3, max = 60)
    private String name;

    @NotNull(message = "A quantidade de equipamento não pode ser null")
    @Min(value = 1, message = "A quantidade de equipamento não pode ser menor que 1")
    private Integer quantity;

    public EquipmentDTO(Long id, String name, Integer quantity){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public EquipmentDTO( ){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
