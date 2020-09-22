package com.monster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monster.persistence.entity.Settore;

@Repository
@Transactional
public interface SettoreRepository extends JpaRepository<Settore, Long>{

	Settore findByNome(String nome);
}
