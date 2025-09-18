package vitoravelar.academy.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import vitoravelar.academy.dto.UserDTO;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "payment_date", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate paymentDate;

    @Column(name = "late_payment", nullable = false)
    private boolean latePayment = false;

    @ManyToOne
    @Column(name = "academy", nullable = false)
    private Academy academy;

    public User(UserDTO userDTO) {
        this.cpf = userDTO.getCpf();
        this.name = userDTO.getName();
        this.paymentDate = userDTO.getPaymentDate();
    }

    public UserDTO toDTO() {
        return new UserDTO(id, cpf, name, paymentDate);
    }
}
