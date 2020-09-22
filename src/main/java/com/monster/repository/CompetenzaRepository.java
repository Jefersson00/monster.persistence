package com.monster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monster.persistence.entity.Competenza;

@Repository
@Transactional
public interface CompetenzaRepository extends JpaRepository<Competenza, Long>{
	
	Competenza findByNome(String nome);
}
