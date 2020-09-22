package com.monster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monster.persistence.entity.Azienda;

@Repository
@Transactional
public interface AziendaRepository extends JpaRepository<Azienda, Long>{
	
	
	Azienda findByNome(String nome);
	Azienda findByEmail(String email);
	Azienda findByEmailAndPassword(String email,String password);
	
	
}
