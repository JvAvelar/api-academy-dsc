package vitoravelar.academy.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDTO {

    @NotNull
    @Min(value = 1, message = "O id não pode ser menor que 1")
    private Long id;

    @Column(name = "cpf")
    @NotBlank(message = "O CPF do usuário não pode estar vazio")
    private String cpf;

    @NotBlank(message = "O nome do usuário não pode estar vazio")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "A data de pagamento não pode estar vazio")
    @Column(name = "paymentDate")
    private String paymentDate;
}
