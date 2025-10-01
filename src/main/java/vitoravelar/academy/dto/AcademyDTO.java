package vitoravelar.academy.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import vitoravelar.academy.models.Equipment;
import vitoravelar.academy.models.User;

import java.util.List;
import java.util.Objects;


public class AcademyDTO {

    @NotNull(message = "O id da academia não pode ser null")
    @Min(value = 1, message = "O id não pode ser menor que 1")
    private Long id;

    @NotBlank(message = "O nome da academia não pode estar vazio")
    @Size(min = 3, max = 60)
    private String name;

    @NotBlank(message = "O CNPJ da academia não pode estar vazio")
    private String cnpj;

    @NotBlank(message = "O endereço da academia não pode estar vazio")
    private String address;

    @NotNull(message = "A lista de usuários não pode ser null")
    private List<User> users;

    @NotNull(message = "A lista de equipamentos não pode ser null")
    private List<Equipment> equipments;

    public AcademyDTO(Long id, String name, String cnpj, String address, List<User> users, List<Equipment> equipments) {
        this.id = id ;
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
        this.users = users;
        this.equipments = equipments;
    }
    public AcademyDTO(){}


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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AcademyDTO that = (AcademyDTO) o;
        return Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cnpj);
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
