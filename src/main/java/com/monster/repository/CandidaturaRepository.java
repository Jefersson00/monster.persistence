package com.monster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monster.persistence.entity.Annuncio;
import com.monster.persistence.entity.Candidatura;
import com.monster.persistence.entity.Utente;

@Repository
@Transactional
public interface CandidaturaRepository extends JpaRepository<Candidatura, Long>{

	List<Candidatura> findByAnnuncio(Annuncio annuncio);
	List<Candidatura> findByUtente(Utente utente);

}
