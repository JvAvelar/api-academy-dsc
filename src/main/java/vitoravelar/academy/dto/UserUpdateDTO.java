package vitoravelar.academy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {

    @NotBlank(message = "O nome do usuário não pode estar vazio")
    @Size(min = 3, max = 60)
    private String name;

    @NotNull(message = "A data de pagamento não pode estar nulo")
    private LocalDate paymentDate;

}
