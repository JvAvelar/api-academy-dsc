package vitoravelar.academy.dto;

import jakarta.validation.constraints.NotBlank;

public class TokenDTO {
    @NotBlank(message = "O token não pode estar vazio")
    private String token;

    public TokenDTO(String token) {
        this.token = token;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}