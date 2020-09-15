package com.monster.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.persistence.entity.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long>{
	
	Utente findByEmail(String email);
	List<Utente> findByDataNascitaGreaterThanEqual(Date dataNascita);

}
