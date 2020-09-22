package com.monster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monster.persistence.entity.PercorsoFormativo;

@Repository
@Transactional
public interface PercorsoFormativoRepository extends JpaRepository<PercorsoFormativo,Long>{
	
	PercorsoFormativo findByFormazione(String formazione);
		
	

}
