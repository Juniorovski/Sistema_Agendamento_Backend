package com.juniordev.sistema_de_agendamento.repository;

import com.juniordev.sistema_de_agendamento.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {


}
