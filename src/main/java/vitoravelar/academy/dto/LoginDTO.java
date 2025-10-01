package vitoravelar.academy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginDTO {

    @NotBlank(message = "O username de login do usuário não pode estar vazio")
    @Size(min = 6, max = 60)
    private String username;

    @NotBlank(message = "A senha do usuário não pode estar vazio")
    @Size(min = 6, max = 60)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}