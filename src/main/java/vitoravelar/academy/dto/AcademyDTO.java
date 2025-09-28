package vitoravelar.academy.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import vitoravelar.academy.models.Equipment;
import vitoravelar.academy.models.User;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AcademyDTO {

    @NotNull(message = "O id da academia não pode ser null")
    @Min(value = 1, message = "O id não pode ser menor que 1")
    private Long id;

    @NotBlank(message = "O nome da academia não pode estar vazio")
    @Size(min = 3, max = 60)
    private String name;

    @NotBlank(message = "O CNPJ da academia não pode estar vazio")
    private String cnpj;

    private String address;

    private List<User> users;

    private List<Equipment> equipments;

}
