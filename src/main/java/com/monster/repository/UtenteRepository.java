package com.monster.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monster.persistence.entity.Utente;


@Transactional
@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long>{
	
	Utente findByEmail(String email);
	
	Utente findByEmailAndPassword(String email,String password);
	List<Utente> findByDataNascitaGreaterThanEqual(Date dataNascita);

}
