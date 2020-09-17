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

import com.monster.persistence.entity.Esperienza;
import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.UtenteEsperienza;
import com.monster.repository.EsperienzaRepository;
import com.monster.repository.UtenteEsperienzaRepository;
import com.monster.repository.UtenteRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UtenteEsperienzaRepositorytest extends AbstractRepositoryTest{
	private static final Logger logger = LoggerFactory.getLogger(UtenteEsperienzaRepositorytest.class);

	@Autowired
	private UtenteEsperienzaRepository utenteEsperienzaRT;
	
	@Autowired
	private EsperienzaRepository esperienzaRT;
	
	@Autowired
	private UtenteRepository utenteRT;

	@BeforeEach
	@AfterEach
	public void initializeUtenteEsperienzaTest() {
		logger.info("UtenteEsperienzaRepositoryTest.initializeUtenteEsperienzaTest - START");		
		
		utenteEsperienzaRT.deleteAll();
		utenteRT.deleteAll();
		esperienzaRT.deleteAll();
		logger.info("UtenteEsperienzaRepositoryTest.initializeUtenteEsperienzaTest - END");
	}
	
	@Test
	public void testSelectById() {
    	logger.info("UtenteEsperienzaRepositoryTest.testSelectById() - START");    	
    	UtenteEsperienza currentUtenteEsperienza = getFakeUtenteEsperienza();
    	logger.info("UtenteEsperienzaRepositoryTest.testSelectById() - Debug "+getFakeUtenteEsperienza().toString());    	
    	logger.info("UtenteEsperienzaRepositoryTest.testSelectById() - Debug "+currentUtenteEsperienza.toString());    	
    	Assertions.assertTrue(utenteEsperienzaRT.findById(currentUtenteEsperienza.getId()).isPresent());	
		logger.info("UtenteEsperienzaRepositoryTest.testSelectById() - END");
	}
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("UtenteEsperienzaRepositoryTest.testSelectAllFilled() - START");    	
    	getFakeUtenteEsperienza();
    	Assertions.assertTrue(utenteEsperienzaRT.count() == 1);
    	logger.info("UtenteEsperienzaRepositoryTest.testSelectAllFilled() - END");
    }
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("UtenteEsperienzaRepositoryTest.testSelectAllEmpty() - START");    	
    	Assertions.assertTrue(utenteEsperienzaRT.count()==0);
		logger.info("UtenteEsperienzaRepositoryTest.testSelectAllEmpty() - END");
    }
	
	
	@Test
	public void testInsert() {
    	logger.info("UtenteEsperienzaRepositoryTest.testInsert() - START");    	
    	Assertions.assertTrue(utenteEsperienzaRT.count()==0);
    	getFakeUtenteEsperienza();
		Assertions.assertTrue(utenteEsperienzaRT.count()==1);
		logger.info("UtenteEsperienzaRepositoryTest.testInsert() - END");
	}
	
	
	@Test
	public void testSelectByEsperienza() {
    	logger.info("UtenteEsperienzaRepositoryTest.testSelectByEsperienza() - START");
    	Esperienza esperienza = getFakeEsperienza();
    	getFakeUtenteEsperienzaWithEsperienza(esperienza);
		Assertions.assertTrue(utenteEsperienzaRT.findByEsperienza(esperienza).get(0).getEsperienza().getId()==esperienza.getId());	
		logger.info("UtenteEsperienzaRepositoryTest.testSelectByEsperienza() - END");
	}
	
	@Test
	public void testSelectByUtente() {
    	logger.info("UtenteEsperienzaRepositoryTest.testSelectByUtente() - START");
    	Utente utente = getFakeUtente();
    	getFakeUtenteEsperienzaWithUtente(utente);
		Assertions.assertTrue(utenteEsperienzaRT.findByUtente(utente).get(0).getUtente().getId()==utente.getId());	
		logger.info("UtenteEsperienzaRepositoryTest.testSelectByUtente() - END");
	}
	
	
	@Test
	public void testDeleteById() {
    	logger.info("UtenteEsperienzaRepositoryTest.testDeleteById() - START");    	
    	UtenteEsperienza currentUtenteEsperienza = getFakeUtenteEsperienza();
    	Assertions.assertTrue(utenteEsperienzaRT.count()==1);
    	utenteEsperienzaRT.deleteById(currentUtenteEsperienza.getId());
    	Assertions.assertTrue(utenteEsperienzaRT.count()==0);
    	logger.info("UtenteEsperienzaRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
    	logger.info("UtenteEsperienzaRepositoryTest.testDeleteAll() - START");    	
    	getFakeUtenteEsperienza();
    	Assertions.assertTrue(utenteEsperienzaRT.count()==1);
    	getFakeUtenteEsperienza();
    	Assertions.assertTrue(utenteEsperienzaRT.count()==2);
    	utenteEsperienzaRT.deleteAll();
		Assertions.assertTrue(utenteEsperienzaRT.count()==0);
		logger.info("UtenteEsperienzaRepositoryTest.testDeleteAll() - END");
	}

}
