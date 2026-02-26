package com.juniordev.sistema_de_agendamento.repository;

import com.juniordev.sistema_de_agendamento.model.Company;
import com.juniordev.sistema_de_agendamento.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByEmail(String email);

    boolean existsByEmail(String email);
    List<User> findByCompany(Company company);
}
