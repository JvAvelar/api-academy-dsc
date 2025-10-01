package vitoravelar.academy.models;

import jakarta.persistence.*;
import lombok.*;
import vitoravelar.academy.dto.AcademyDTO;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "academy")
    private List<User> users;

    @OneToMany(mappedBy = "academy")
    private List<Equipment> equipments;

    public AcademyDTO toDTO(){
        return new AcademyDTO(id, name, cnpj, address, users, equipments);
    }

    public Academy(){}

    public Academy(AcademyDTO academyDTO){
        this.name = academyDTO.getName();
        this.cnpj = academyDTO.getCnpj();
        this.address = academyDTO.getAddress();
        this.users = academyDTO.getUsers();
        this.equipments = academyDTO.getEquipments();
    }

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

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Academy academy = (Academy) o;
        return Objects.equals(cnpj, academy.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cnpj);
    }
}
