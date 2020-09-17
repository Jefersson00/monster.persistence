package com.monster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.persistence.entity.PercorsoFormativo;
import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.UtentePercorso;
@Repository
public interface UtentePercorsoRepository extends JpaRepository<UtentePercorso, Long> {

	List<UtentePercorso> findByPercorsoFormativo(PercorsoFormativo percorsoFormativo);
	List<UtentePercorso> findByUtente(Utente utente);
}
