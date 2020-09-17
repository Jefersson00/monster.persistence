package com.monster;
//MarcoBraia marco.braia.mb@gmail.com
//in fase di sviluppo

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.monster.persistence.entity.Annuncio;
import com.monster.persistence.entity.Candidatura;
import com.monster.persistence.entity.Utente;
import com.monster.repository.AnnuncioRepository;
import com.monster.repository.CandidaturaRepository;
import com.monster.repository.UtenteRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CandidaturaRepositoryTest extends AbstractRepositoryTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CandidaturaRepositoryTest.class);

	@Autowired
	private CandidaturaRepository candidaturaRT;
	
	@Autowired
	private AnnuncioRepository annuncioRT;
	
	@Autowired
	private UtenteRepository utenteRT;
	
	@BeforeEach
	@AfterEach
	public void initializeCandidaturaTest() {
		logger.info("CandidaturaRepositoryTest.initializeCandidaturaTest - START");		
		candidaturaRT.deleteAll();
		annuncioRT.deleteAll();
		utenteRT.deleteAll();
		logger.info("CandidaturaRepositoryTest.initializeCandidaturaTest - END");
	}
	
	@Test
	public void testSelectById() {
    	logger.info("CandidaturaRepositoryTest.testSelectById() - START");    	
    	Candidatura currentCandidatura = getFakeCandidatura();
    	logger.info("CandidaturaRepositoryTest.testSelectById() - Debug "+getFakeCandidatura().toString());    	
    	logger.info("CandidaturaRepositoryTest.testSelectById() - Debug "+currentCandidatura.toString());    	
    	Assertions.assertTrue(candidaturaRT.findById(currentCandidatura.getId()).isPresent());	
		logger.info("CandidaturaRepositoryTest.testSelectById() - END");
	}
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("CandidaturaRepositoryTest.testSelectAllFilled() - START");    	
    	getFakeCandidatura();
    	Assertions.assertTrue(candidaturaRT.count() == 1);
    	logger.info("CandidaturaRepositoryTest.testSelectAllFilled() - END");
    }
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("CandidaturaRepositoryTest.testSelectAllEmpty() - START");    	
    	Assertions.assertTrue(candidaturaRT.count()==0);
		logger.info("CandidaturaRepositoryTest.testSelectAllEmpty() - END");
    }
	
	
	@Test
	public void testInsert() {
    	logger.info("CandidaturaRepositoryTest.testInsert() - START");    	
    	Assertions.assertTrue(candidaturaRT.count()==0);
    	getFakeCandidatura();
		Assertions.assertTrue(candidaturaRT.count()==1);
		logger.info("CandidaturaRepositoryTest.testInsert() - END");
	}
	
	
	@Test
	public void testSelectByAnnuncio() {
    	logger.info("CandidaturaRepositoryTest.testSelectByAnnuncio() - START");
    	Annuncio annuncio = getFakeAnnuncio();
    	getFakeCandidaturaWithAnnuncio(annuncio);
		Assertions.assertTrue(candidaturaRT.findByAnnuncio(annuncio).get(0).getAnnuncio().getId()==annuncio.getId());	
		logger.info("CandidaturaRepositoryTest.testSelectByAnnuncio() - END");
	}
	
	@Test
	public void testSelectByUtente() {
    	logger.info("CandidaturaRepositoryTest.testSelectByUtente() - START");
    	Utente utente = getFakeUtente();
    	getFakeCandidaturaWithUtente(utente);
		Assertions.assertTrue(candidaturaRT.findByUtente(utente).get(0).getUtente().getId()==utente.getId());	
		logger.info("CandidaturaRepositoryTest.testSelectByUtente() - END");
	}
	
	/* devo pensare ad un test update per la tabella unione
	@Test
	public void testUpdate() {
		logger.info("CandidaturaRepositoryTest.testUpdate() - START");
		Candidatura currentCandidatura = getFakeCandidatura();
		String descrizione ="modifica descrizione test";
		currentCandidatura.setDescrizione(descrizione);
		candidaturaRT.save(currentCandidatura);
		Assertions.assertTrue(candidaturaRT.findById(currentCandidatura.getId()).isPresent());	
		Assertions.assertTrue(candidaturaRT.findById(currentCandidatura.getId()).get().getDescrizione().equals(descrizione));
		logger.info("CandidaturaRepositoryTest.testUpdate() - END");
	}*/
	
	@Test
	public void testDeleteById() {
    	logger.info("CandidaturaRepositoryTest.testDeleteById() - START");    	
    	Candidatura currentCandidatura = getFakeCandidatura();
    	Assertions.assertTrue(candidaturaRT.count()==1);
    	candidaturaRT.deleteById(currentCandidatura.getId());
    	Assertions.assertTrue(candidaturaRT.count()==0);
    	logger.info("CandidaturaRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
    	logger.info("CandidaturaRepositoryTest.testDeleteAll() - START");    	
    	getFakeCandidatura();
    	Assertions.assertTrue(candidaturaRT.count()==1);
    	getFakeCandidatura();
    	Assertions.assertTrue(candidaturaRT.count()==2);
    	candidaturaRT.deleteAll();
		Assertions.assertTrue(candidaturaRT.count()==0);
		logger.info("CandidaturaRepositoryTest.testDeleteAll() - END");
	}

}
