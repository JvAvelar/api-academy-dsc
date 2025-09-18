package vitoravelar.academy.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDTO {

    @NotNull(message = "O id do usuário não pode ser null")
    @Min(value = 1, message = "O id não pode ser menor que 1")
    private Long id;

    @NotBlank(message = "O CPF do usuário não pode estar vazio")
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank(message = "O nome do usuário não pode estar vazio")
    @Size(min = 3, max = 60)
    private String name;

    @NotNull(message = "A data de pagamento não pode estar nulo")
    private LocalDate paymentDate;
}
