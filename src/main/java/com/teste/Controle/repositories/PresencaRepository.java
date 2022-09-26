package com.teste.Controle.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.teste.Controle.entities.Presenca;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Long>{

	List<Presenca> findByPresencaBetween (Date start, Date end);
}
