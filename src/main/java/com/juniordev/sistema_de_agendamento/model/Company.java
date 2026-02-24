package com.juniordev.sistema_de_agendamento.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "company_tb")
public class Company {
    public Company(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;
    @OneToMany(mappedBy = "company")
    private List<User> users;
    @OneToMany(mappedBy = "company")
    private List<Client> clients;
    @OneToMany(mappedBy = "company")
    private List<Service> services;

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @OneToMany(mappedBy = "company")
    private List<Schedule> schedules;

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }


    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @PrePersist
    public void prePersit(){
        this.created_at = LocalDateTime.now();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
