package vitoravelar.academy.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentUpdateDTO {

    @NotBlank(message = "O nome do equipamento não pode estar vazio")
    @Size(min = 3, max = 60)
    private String name;

    @NotNull(message = "A quantidade de equipamento não pode ser null")
    @Min(value = 1, message = "A quantidade de equipamento não pode ser menor que 1")
    private Integer quantity;
}
