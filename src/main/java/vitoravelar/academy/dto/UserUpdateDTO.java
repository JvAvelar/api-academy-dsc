package vitoravelar.academy.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {

    @NotBlank(message = "O nome do usuário não pode estar vazio")
    private String name;

    @NotBlank(message = "A data de pagamento não pode estar vazio")
    private String paymentDate;

}
