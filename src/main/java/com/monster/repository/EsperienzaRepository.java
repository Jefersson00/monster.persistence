package com.monster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.persistence.entity.Esperienza;

@Repository
public interface EsperienzaRepository extends JpaRepository<Esperienza, Long>{
	
	
	Esperienza findByNomeAzienda(String nomeAzienda);

}
