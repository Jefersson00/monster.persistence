package com.monster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.persistence.entity.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long>{
	
	List<Sede> findByCitta(String Citta);
	List<Sede> findByRegione(String Regione);
	
}
