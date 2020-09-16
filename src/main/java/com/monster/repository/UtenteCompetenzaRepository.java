package com.monster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.monster.persistence.entity.Competenza;
import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.UtenteCompetenza;

public interface UtenteCompetenzaRepository extends JpaRepository<UtenteCompetenza, Long> {

	
	List<UtenteCompetenza> findByCompetenza_Id(long id);
	
	List<UtenteCompetenza> findByCompetenza_nome(String nome);
	
	List<UtenteCompetenza> findByUtente_Id(long id);
	
//	List<Utente> findByCompetenza_Id(long id);
//	
//	List<Utente> findByUtente_Id(long id);
	
}
