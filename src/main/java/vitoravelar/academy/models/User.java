package vitoravelar.academy.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vitoravelar.academy.dto.UserDTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "payment_date", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate paymentDate;

    @Column(name = "late_payment", nullable = false)
    private boolean latePayment = false;

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    public User(){}

    public User(UserDTO userDTO) {
        cpf = userDTO.getCpf();
        name = userDTO.getName();
        username = userDTO.getUsername();
        password = userDTO.getPassword();
        paymentDate = userDTO.getPaymentDate();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
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

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isLatePayment() {
        return latePayment;
    }

    public void setLatePayment(boolean latePayment) {
        this.latePayment = latePayment;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(cpf, user.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    public UserDTO toDTO() {
        return new UserDTO(id, cpf, name);
    }
}
