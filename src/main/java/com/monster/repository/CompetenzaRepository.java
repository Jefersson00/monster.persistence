package com.monster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.persistence.entity.Competenza;

@Repository
public interface CompetenzaRepository extends JpaRepository<Competenza, Long>{
	
	Competenza findByNome(String nome);
}
