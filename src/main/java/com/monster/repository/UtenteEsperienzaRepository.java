package com.monster.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monster.persistence.entity.Esperienza;
import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.UtenteEsperienza;

@Transactional
@Repository
public interface UtenteEsperienzaRepository extends JpaRepository<UtenteEsperienza, Long> {
	
	List<UtenteEsperienza> findByUtente(Utente utente); 
	List<UtenteEsperienza> findByEsperienza(Esperienza esperienza);

}
