package com.monster.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.persistence.entity.Annuncio;

@Repository
public interface AnnuncioRepository extends JpaRepository<Annuncio, Long>{
	List<Annuncio> findByDataPubblicazioneGreaterThanEqual(Date dataPubblicazione);
	List<Annuncio>findByContratto(String contratto);
}
