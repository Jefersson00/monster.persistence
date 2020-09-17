package com.monster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.persistence.entity.Esperienza;
import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.UtenteEsperienza;
@Repository
public interface UtenteEsperienzaRepository extends JpaRepository<UtenteEsperienza, Long> {
	
	List<UtenteEsperienza> findByUtente(Utente utente); 
	List<UtenteEsperienza> findByUtenteId(Esperienza esperienza);

}
