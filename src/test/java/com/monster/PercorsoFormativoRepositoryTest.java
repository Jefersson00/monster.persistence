package com.monster;

import static org.junit.jupiter.api.Assertions.*;

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
import com.monster.repository.EsperienzaRepository;
import com.monster.repository.PercorsoFormativoRepository;

//@srfcristhian@gmail.com
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PercorsoFormativoRepositoryTest extends AbstractRepositoryTest{

	private static final Logger logger = LoggerFactory.getLogger(PercorsoFormativoRepositoryTest.class);
	
	@Autowired
	private PercorsoFormativoRepository percorsoFormativoRT;
	
	@BeforeEach
	@AfterEach
	public void initializePercorsoFormativoTest() {
		logger.info("PercorsoFormativoRepositoryTest.initializePercorsoFormativoTest - START");		
		percorsoFormativoRT.deleteAll();
		logger.info("PercorsoFormativoRepositoryTest.initializePercorsoFormativoTest - END");
	}
	@Test
	public void testSelectById() {
    	logger.info("PercorsoFormativoRepositoryTest.testSelectById() - START");    	
    	PercorsoFormativo currentPercorsoFormativo = getFakePercorsoFormativo();
    	logger.info("PercorsoFormativoRepositoryTest.testSelectById() - Debug "+getFakePercorsoFormativo().toString());    	
    	logger.info("PercorsoFormativoRepositoryTest.testSelectById() - Debug "+currentPercorsoFormativo.toString());    	
    	Assertions.assertTrue(percorsoFormativoRT.findById(currentPercorsoFormativo.getId()).isPresent());	
		logger.info("PercorsoFormativoRepositoryTest.testSelectById() - END");

	}
	@Test
	public void testSelectAllFilled() {
		logger.info("PercorsoFormativoRepositoryTest.testSelectAllFilled() - START");
		getFakePercorsoFormativo();
		Assertions.assertTrue(percorsoFormativoRT.count() == 1);
		logger.info("PercorsoFormativoRepositoryTest.testSelectAllFilled() - END");
	}
	
	@Test
	public void testSelectAllEmpty() {
		logger.info("PercorsoFormativoRepositoryTest.testSelectAllEmpty() - START");
		Assertions.assertTrue(percorsoFormativoRT.count() == 0);
		logger.info("PercorsoFormativoRepositoryTest.testSelectAllEmpty() - END");
	}
	
	@Test
	public void testInsert() {
		logger.info("PercorsoFormativoRepositoryTest.testInsert() - START");
		Assertions.assertTrue(percorsoFormativoRT.count()==0);
		getFakePercorsoFormativo();
		Assertions.assertTrue(percorsoFormativoRT.count()==1);
		logger.info("PercorsoFormativoRepositoryTest.testInsert() - END");
	}
	
	@Test
	public void testSelectbyFormazione() {
		logger.info("PercorsoFormativoRepositoryTest.testSelectByNameAzienda() - START");
		int random = (int) (Math.random() * 10000);
		String formazione = "FormazioneProva" + random;
		getFakePercorsoFormativoWithFormazione(formazione);
		
		Assertions.assertTrue(percorsoFormativoRT.findByFormazione(formazione).getFormazione().equals(formazione));
		logger.info("PercorsoFormativoRepositoryTest.testSelectByNameAzienda() - END");
		
	}
	@Test
	public void testUpdate() {
		logger.info("PercorsoFormativoRepositoryTest.testUpdate() - START");
		PercorsoFormativo currentPercorsoFormativo = getFakePercorsoFormativo();
		String descrizione = "modifica descrizione test";
		currentPercorsoFormativo.setDescrizione(descrizione);
		percorsoFormativoRT.save(currentPercorsoFormativo);
		Assertions.assertTrue(percorsoFormativoRT.findById(currentPercorsoFormativo.getId()).isPresent());
		Assertions.assertTrue(percorsoFormativoRT.findById(currentPercorsoFormativo.getId()).get().getDescrizione().equals(descrizione));
		logger.info("PercorsoFormativoRepositoryTest.testUpdate() - END");
		
	}
	@Test
	public void testDeleteById() {
		logger.info("PercorsoFormativoRepositoryTest.testDeleteById() - START");
		PercorsoFormativo currentPercorsoFormativo = getFakePercorsoFormativo();
		Assertions.assertTrue(percorsoFormativoRT.count()==1);
		percorsoFormativoRT.deleteById(currentPercorsoFormativo.getId());
		Assertions.assertTrue(percorsoFormativoRT.count()==0);
		logger.info("PercorsoFormativoRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
		logger.info("PercorsoFormativoRepositoryTest.testDeleteAll() - START");
		getFakePercorsoFormativo();
		Assertions.assertTrue(percorsoFormativoRT.count()==1);
		getFakePercorsoFormativo();
		Assertions.assertTrue(percorsoFormativoRT.count()==2);
		percorsoFormativoRT.deleteAll();
		Assertions.assertTrue(percorsoFormativoRT.count()==0);
		logger.info("PercorsoFormativoRepositoryTest.testDeleteAll() - END");
		
	}
}

