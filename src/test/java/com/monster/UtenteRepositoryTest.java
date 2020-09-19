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

import com.monster.persistence.entity.Azienda;
import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.Utente;
import com.monster.repository.AziendaRepository;
import com.monster.repository.UtenteRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UtenteRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(UtenteRepositoryTest.class);

	@Autowired
	UtenteRepository utenteRT;

	@BeforeEach
	@AfterEach
	public void initializeUtenteTest() {
		logger.info("UtenteRepositoryTest.initializeUtenteTest - START");
		utenteRT.deleteAll();
		logger.info("UtenteRepositoryTest.initializeUtenteTest - END");
	}

	@Test
	public void testSelectByEmail() {
		logger.info("UtenteRepositoryTest.testSelectByName() - START");
		Utente currentUtente = getFakeUtente();
		logger.info("UtenteRepositoryTest.testSelectByName() - Debug " + currentUtente.toString());
		Assertions.assertTrue(utenteRT.findById(currentUtente.getId()).isPresent());
		logger.info("UtenteRepositoryTest.testSelectByName() - END");
	}
	
	
	
	@Test
	public void testSelectById() {
    	logger.info("UtenteRepositoryTest.testSelectById() - START");    	
    	Utente currentUtente = getFakeUtente();
    	logger.info("UtenteRepositoryTest.testSelectById() - Debug "+getFakeUtente().toString());    	
    	logger.info("UtenteRepositoryTest.testSelectById() - Debug "+currentUtente.toString());    	
    	Assertions.assertTrue(utenteRT.findById(currentUtente.getId()).isPresent());	
		logger.info("UtenteRepositoryTest.testSelectById() - END");

	}
	@Test
	public void testSelectAllFilled() {
		logger.info("UtenteRepositoryTest.testSelectAllFilled() - START");
		getFakeUtente();
		Assertions.assertTrue(utenteRT.count() == 1);
		logger.info("UtenteRepositoryTest.testSelectAllFilled() - END");
	}
	
	@Test
	public void testSelectAllEmpty() {
		logger.info("UtenteRepositoryTest.testSelectAllEmpty() - START");
		Assertions.assertTrue(utenteRT.count() == 0);
		logger.info("UtenteRepositoryTest.testSelectAllEmpty() - END");
	}
	
	@Test
	public void testInsert() {
		logger.info("UtenteRepositoryTest.testInsert() - START");
		Assertions.assertTrue(utenteRT.count()==0);
		getFakeUtente();
		Assertions.assertTrue(utenteRT.count()==1);
		logger.info("UtenteRepositoryTest.testInsert() - END");
	}
	
	@Test
	public void testUpdate() {
		logger.info("UtenteRepositoryTest.testUpdate() - START");
		Utente currentUtente = getFakeUtente();
		String nome = "modifica nome test";
		currentUtente.setNome(nome);
		utenteRT.save(currentUtente);
		Assertions.assertTrue(utenteRT.findById(currentUtente.getId()).isPresent());
		Assertions.assertTrue(utenteRT.findById(currentUtente.getId()).get().getNome().equals(nome));
		logger.info("UtenteRepositoryTest.testUpdate() - END");
		
	}
	@Test
	public void testDeleteById() {
		logger.info("UtenteRepositoryTest.testDeleteById() - START");
		Utente currentUtente = getFakeUtente();
		Assertions.assertTrue(utenteRT.count()==1);
		utenteRT.deleteById(currentUtente.getId());
		Assertions.assertTrue(utenteRT.count()==0);
		logger.info("UtenteRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
		logger.info("UtenteRepositoryTest.testDeleteAll() - START");
		getFakeUtente();
		Assertions.assertTrue(utenteRT.count()==1);
		getFakeUtente();
		Assertions.assertTrue(utenteRT.count()==2);
		utenteRT.deleteAll();
		Assertions.assertTrue(utenteRT.count()==0);
		logger.info("UtenteRepositoryTest.testDeleteAll() - END");
		
	}
	
}
