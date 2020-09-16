package com.monster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.UtenteEsperienza;
@Repository
public interface UtenteEsperienzaRepository extends JpaRepository<UtenteEsperienza, Long> {
	
	List<UtenteEsperienza> findByUtente(Utente utente); 
	
	List<UtenteEsperienza> findByUtente_Id(long id);
	
	List<UtenteEsperienza> findByEsperienza_NomeAzienda(String nomeAzienda);
	

//	List<Utente> findByUtente(Utente utente); 
//	
//	List<Utente> findByUtente_Id(long id);

}
