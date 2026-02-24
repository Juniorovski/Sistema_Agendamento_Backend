package com.juniordev.sistema_de_agendamento.repository;

import com.juniordev.sistema_de_agendamento.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("""
SELECT s FROM Schedule s
WHERE s.company.id = :companyId
AND s.date = :date
AND s.status <> 'CANCELED'
AND (
    :start < s.endTime AND
    :end > s.startTime
)
""")
    List<Schedule> findConflicts(
            Long companyId,
            LocalDate date,
            LocalTime start,
            LocalTime end
    );
}
