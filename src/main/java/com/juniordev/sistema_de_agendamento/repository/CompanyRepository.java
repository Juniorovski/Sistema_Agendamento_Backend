package com.juniordev.sistema_de_agendamento.repository;

import com.juniordev.sistema_de_agendamento.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Optional<Company>findByEmail(String email);
}
