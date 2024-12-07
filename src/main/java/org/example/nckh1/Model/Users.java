package org.example.nckh1.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private  String Avatar;
    private String username;

    private String password;

    private String email;

    private String location;

    private LocalDateTime createdAt;

    private String formattedDate;

    private String phone;

    @Transient
    private String rePassword;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles role;


}
