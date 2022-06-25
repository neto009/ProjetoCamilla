package com.camilla.repository;

import com.camilla.domain.DateConsult;
import com.camilla.domain.Form;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {
    @Query(value = "select * from form where publication_date between convert(:dataInicio, date) and convert(:dataFim, date)", nativeQuery = true)
    List<Form> searchPublicationDateBetween(@Param("dataInicio") String dataInicio, @Param("dataFim") String Fim);
}
