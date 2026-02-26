package com.juniordev.sistema_de_agendamento.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "user_tb")
public class User {

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    private LocalDateTime created_at;


    @PrePersist
    public void prePersit(){
        this.created_at = LocalDateTime.now();
    }
    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company= company;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }




}
