package com.monster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monster.persistence.entity.PercorsoFormativo;
import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.UtentePercorso;

@Transactional
@Repository
public interface UtentePercorsoRepository extends JpaRepository<UtentePercorso, Long> {

	List<UtentePercorso> findByPercorsoFormativo(PercorsoFormativo percorsoFormativo);
	List<UtentePercorso> findByUtente(Utente utente);
}
