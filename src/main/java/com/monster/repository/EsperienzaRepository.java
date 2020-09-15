package com.monster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.persistence.entity.Candidatura;
import com.monster.persistence.entity.Esperienza;
import com.monster.persistence.entity.Utente;

@Repository
public interface EsperienzaRepository extends JpaRepository<Esperienza, Long>{

	
	/*
	 * la query precedente era fatta male perche sulla tabella esperienza
	 * possono esistere n record con l identico campo nomeAzienda, di
	 * conseguenza quello che riceviamo dalla query e una lista di esperienza
	 */
	
	List<Esperienza> findByNomeAzienda(String nomeAzienda);

}
