package com.monster;

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
import com.monster.persistence.entity.Azienda;
import com.monster.persistence.entity.Competenza;
import com.monster.persistence.entity.UtenteCompetenza;
import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.UtenteCompetenza;
import com.monster.repository.AziendaRepository;
import com.monster.repository.UtenteCompetenzaRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UtenteCompetenzaRepositorytest extends AbstractRepositoryTest{

	private static final Logger logger = LoggerFactory.getLogger(UtenteCompetenzaRepositorytest.class);

	@Autowired
	private UtenteCompetenzaRepository utenteCompetenzaRT;

	@BeforeEach
	@AfterEach
	public void initializeUtenteCompetenzaTest() {
		logger.info("UtenteCompetenzaRepositoryTest.initializeUtenteCompetenzaTest - START");		
		utenteCompetenzaRT.deleteAll();
		logger.info("UtenteCompetenzaRepositoryTest.initializeUtenteCompetenzaTest - END");
	}
	
	@Test
	public void testSelectById() {
    	logger.info("UtenteCompetenzaRepositoryTest.testSelectById() - START");    	
    	UtenteCompetenza currentUtenteCompetenza = getFakeUtenteCompetenza();
    	logger.info("UtenteCompetenzaRepositoryTest.testSelectById() - Debug "+getFakeUtenteCompetenza().toString());    	
    	logger.info("UtenteCompetenzaRepositoryTest.testSelectById() - Debug "+currentUtenteCompetenza.toString());    	
    	Assertions.assertTrue(utenteCompetenzaRT.findById(currentUtenteCompetenza.getId()).isPresent());	
		logger.info("UtenteCompetenzaRepositoryTest.testSelectById() - END");
	}
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("UtenteCompetenzaRepositoryTest.testSelectAllFilled() - START");    	
    	getFakeUtenteCompetenza();
    	Assertions.assertTrue(utenteCompetenzaRT.count() == 1);
    	logger.info("UtenteCompetenzaRepositoryTest.testSelectAllFilled() - END");
    }
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("UtenteCompetenzaRepositoryTest.testSelectAllEmpty() - START");    	
    	Assertions.assertTrue(utenteCompetenzaRT.count()==0);
		logger.info("UtenteCompetenzaRepositoryTest.testSelectAllEmpty() - END");
    }
	
	
	@Test
	public void testInsert() {
    	logger.info("UtenteCompetenzaRepositoryTest.testInsert() - START");    	
    	Assertions.assertTrue(utenteCompetenzaRT.count()==0);
    	getFakeUtenteCompetenza();
		Assertions.assertTrue(utenteCompetenzaRT.count()==1);
		logger.info("UtenteCompetenzaRepositoryTest.testInsert() - END");
	}
	
	
	@Test
	public void testSelectByCompetenza() {
    	logger.info("UtenteCompetenzaRepositoryTest.testSelectByCompetenza() - START");
    	Competenza competenza = getFakeCompetenza();
    	getFakeUtenteCompetenzaWithCompetenza(competenza);
		Assertions.assertTrue(utenteCompetenzaRT.findByCompetenza(competenza).get(0).getCompetenza().getId()==competenza.getId());	
		logger.info("UtenteCompetenzaRepositoryTest.testSelectByCompetenza() - END");
	}
	
	@Test
	public void testSelectByUtente() {
    	logger.info("UtenteCompetenzaRepositoryTest.testSelectByUtente() - START");
    	Utente utente = getFakeUtente();
    	getFakeUtenteCompetenzaWithUtente(utente);
		Assertions.assertTrue(utenteCompetenzaRT.findByUtente(utente).get(0).getUtente().getId()==utente.getId());	
		logger.info("UtenteCompetenzaRepositoryTest.testSelectByUtente() - END");
	}
	
	
	@Test
	public void testDeleteById() {
    	logger.info("UtenteCompetenzaRepositoryTest.testDeleteById() - START");    	
    	UtenteCompetenza currentUtenteCompetenza = getFakeUtenteCompetenza();
    	Assertions.assertTrue(utenteCompetenzaRT.count()==1);
    	utenteCompetenzaRT.deleteById(currentUtenteCompetenza.getId());
    	Assertions.assertTrue(utenteCompetenzaRT.count()==0);
    	logger.info("UtenteCompetenzaRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
    	logger.info("UtenteCompetenzaRepositoryTest.testDeleteAll() - START");    	
    	getFakeUtenteCompetenza();
    	Assertions.assertTrue(utenteCompetenzaRT.count()==1);
    	getFakeUtenteCompetenza();
    	Assertions.assertTrue(utenteCompetenzaRT.count()==2);
    	utenteCompetenzaRT.deleteAll();
		Assertions.assertTrue(utenteCompetenzaRT.count()==0);
		logger.info("UtenteCompetenzaRepositoryTest.testDeleteAll() - END");
	}
	
}
