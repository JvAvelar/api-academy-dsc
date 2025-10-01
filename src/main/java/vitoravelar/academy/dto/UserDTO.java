package vitoravelar.academy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

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

    @NotBlank(message = "O username de login do usuário não pode estar vazio")
    @Size(min = 6, max = 60)
    private String username;

    @NotBlank(message = "A senha do usuário não pode estar vazio")
    @Size(min = 6, max = 60)
    private String password;

    @NotNull(message = "A data de pagamento não pode estar nulo")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate paymentDate;

    public UserDTO(){}

    public UserDTO(Long id, String cpf, String name ){
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        paymentDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(cpf, userDTO.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
