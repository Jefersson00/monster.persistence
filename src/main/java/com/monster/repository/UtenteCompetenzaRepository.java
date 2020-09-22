package com.monster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monster.persistence.entity.Competenza;
import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.UtenteCompetenza;

@Repository
@Transactional
public interface UtenteCompetenzaRepository extends JpaRepository<UtenteCompetenza, Long> {

	
	List<UtenteCompetenza> findByCompetenza(Competenza competenza);
	List<UtenteCompetenza> findByUtente(Utente utente);
	
}
