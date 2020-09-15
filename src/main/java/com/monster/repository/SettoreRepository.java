package com.monster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monster.persistence.entity.Azienda;
import com.monster.persistence.entity.Settore;

public interface SettoreRepository extends JpaRepository<Settore, Long>{

	Settore findByNome(String nome);
}
