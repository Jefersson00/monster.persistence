package com.monster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.persistence.entity.PercorsoFormativo;

@Repository
public interface PercorsoFormativoRepository extends JpaRepository<PercorsoFormativo,Long>{
	
	PercorsoFormativo findByFormazione(String formazione);
		
	

}
