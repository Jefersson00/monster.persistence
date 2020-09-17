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

import com.monster.persistence.entity.PercorsoFormativo;
import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.UtentePercorso;
import com.monster.persistence.entity.UtentePercorso;
import com.monster.repository.PercorsoFormativoRepository;
import com.monster.repository.UtentePercorsoRepository;
import com.monster.repository.UtenteRepository;
import com.monster.repository.UtentePercorsoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UtentePercorsoRepositoryTest extends AbstractRepositoryTest{
	private static final Logger logger = LoggerFactory.getLogger(UtentePercorsoRepositoryTest.class);

	@Autowired
	private UtentePercorsoRepository utentePercorsoRT;
	
	@Autowired
	private UtenteRepository utenteRT;
	
	@Autowired
	private PercorsoFormativoRepository percorsoFormativoRT;

	@BeforeEach
	@AfterEach
	public void initializeUtentePercorsoTest() {
		logger.info("UtentePercorsoRepositoryTest.initializeUtentePercorsoTest - START");		
		utentePercorsoRT.deleteAll();
		utenteRT.deleteAll();
		percorsoFormativoRT.deleteAll();
		logger.info("UtentePercorsoRepositoryTest.initializeUtentePercorsoTest - END");
	}
	
	@Test
	public void testSelectById() {
    	logger.info("UtentePercorsoRepositoryTest.testSelectById() - START");    	
    	UtentePercorso currentUtentePercorso = getFakeUtentePercorso();
    	logger.info("UtentePercorsoRepositoryTest.testSelectById() - Debug "+getFakeUtentePercorso().toString());    	
    	logger.info("UtentePercorsoRepositoryTest.testSelectById() - Debug "+currentUtentePercorso.toString());    	
    	Assertions.assertTrue(utentePercorsoRT.findById(currentUtentePercorso.getId()).isPresent());	
		logger.info("UtentePercorsoRepositoryTest.testSelectById() - END");
	}
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("UtentePercorsoRepositoryTest.testSelectAllFilled() - START");    	
    	getFakeUtentePercorso();
    	Assertions.assertTrue(utentePercorsoRT.count() == 1);
    	logger.info("UtentePercorsoRepositoryTest.testSelectAllFilled() - END");
    }
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("UtentePercorsoRepositoryTest.testSelectAllEmpty() - START");    	
    	Assertions.assertTrue(utentePercorsoRT.count()==0);
		logger.info("UtentePercorsoRepositoryTest.testSelectAllEmpty() - END");
    }
	
	
	@Test
	public void testInsert() {
    	logger.info("UtentePercorsoRepositoryTest.testInsert() - START");    	
    	Assertions.assertTrue(utentePercorsoRT.count()==0);
    	getFakeUtentePercorso();
		Assertions.assertTrue(utentePercorsoRT.count()==1);
		logger.info("UtentePercorsoRepositoryTest.testInsert() - END");
	}
	
	
	@Test
	public void testSelectByPercorso() {
    	logger.info("UtentePercorsoRepositoryTest.testSelectByPercorso() - START");
    	PercorsoFormativo percorsoFormativo = getFakePercorsoFormativo();
    	getFakeUtentePercorsoWithPercorso(percorsoFormativo);
		Assertions.assertTrue(utentePercorsoRT.findByPercorsoFormativo(percorsoFormativo).get(0).getPercorsoFormativo().getId()==percorsoFormativo.getId());	
		logger.info("UtentePercorsoRepositoryTest.testSelectByPercorso() - END");
	}
	
	@Test
	public void testSelectByUtente() {
    	logger.info("UtentePercorsoRepositoryTest.testSelectByUtente() - START");
    	Utente utente = getFakeUtente();
    	getFakeUtentePercorsoWithUtente(utente);
		Assertions.assertTrue(utentePercorsoRT.findByUtente(utente).get(0).getUtente().getId()==utente.getId());	
		logger.info("UtentePercorsoRepositoryTest.testSelectByUtente() - END");
	}
	
	
	@Test
	public void testDeleteById() {
    	logger.info("UtentePercorsoRepositoryTest.testDeleteById() - START");    	
    	UtentePercorso currentUtentePercorso = getFakeUtentePercorso();
    	Assertions.assertTrue(utentePercorsoRT.count()==1);
    	utentePercorsoRT.deleteById(currentUtentePercorso.getId());
    	Assertions.assertTrue(utentePercorsoRT.count()==0);
    	logger.info("UtentePercorsoRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
    	logger.info("UtentePercorsoRepositoryTest.testDeleteAll() - START");    	
    	getFakeUtentePercorso();
    	Assertions.assertTrue(utentePercorsoRT.count()==1);
    	getFakeUtentePercorso();
    	Assertions.assertTrue(utentePercorsoRT.count()==2);
    	utentePercorsoRT.deleteAll();
		Assertions.assertTrue(utentePercorsoRT.count()==0);
		logger.info("UtentePercorsoRepositoryTest.testDeleteAll() - END");
	}

}
