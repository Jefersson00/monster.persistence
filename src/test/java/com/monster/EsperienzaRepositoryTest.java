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

import com.monster.persistence.entity.Azienda;
import com.monster.persistence.entity.Esperienza;
import com.monster.repository.EsperienzaRepository;

//@srfcristhian@gmail.com
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EsperienzaRepositoryTest extends AbstractRepositoryTest{

	private static final Logger logger = LoggerFactory.getLogger(EsperienzaRepositoryTest.class);
	
	@Autowired
	private EsperienzaRepository esperienzaRT;
	
	@BeforeEach
	@AfterEach
	public void initializeEsperienzaTest() {
		logger.info("EsperienzaRepositoryTest.initializeEsperienzaTest - START");		
		esperienzaRT.deleteAll();
		logger.info("EsperienzaRepositoryTest.initializeEsperienzaTest - END");
	}
	@Test
	public void testSelectById() {
    	logger.info("EsperienzaRepositoryTest.testSelectById() - START");    	
    	Esperienza currentEsperienza = getFakeEsperienza();
    	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    	System.out.println(getFakeEsperienza().toString());
    	logger.info("EsperienzaRepositoryTest.testSelectById() - Debug "+currentEsperienza.toString());    	
    	Assertions.assertTrue(esperienzaRT.findById(currentEsperienza.getId()).isPresent());	
		logger.info("EsperienzaRepositoryTest.testSelectById() - END");

	}
	@Test
	public void testSelectAllFilled() {
		logger.info("EsperienzaRepositoryTest.testSelectAllFilled() - START");
		getFakeEsperienza();
		Assertions.assertTrue(esperienzaRT.count() == 1);
		logger.info("EsperienzaRepositoryTest.testSelectAllFilled() - END");
	}
	
	@Test
	public void testSelectAllEmpty() {
		logger.info("EsperienzaRepositoryTest.testSelectAllEmpty() - START");
		Assertions.assertTrue(esperienzaRT.count() == 0);
		logger.info("EsperienzaRepositoryTest.testSelectAllEmpty() - END");
	}
	
	@Test
	public void testInsert() {
		logger.info("EsperienzaRepositoryTest.testInsert() - START");
		Assertions.assertTrue(esperienzaRT.count()==0);
		getFakeEsperienza();
		Assertions.assertTrue(esperienzaRT.count()==1);
		logger.info("EsperienzaRepositoryTest.testInsert() - END");
	}
	
	@Test
	public void testSelectbyNameAzienda() {
		logger.info("EsperienzaRepositoryTest.testSelectByNameAzienda() - START");
		int random = (int) (Math.random() * 10000);
		String name = "AziendaProva" + random;
		getFakeEsperienzaWithNameAzienda(name);
		Assertions.assertTrue(esperienzaRT.findByNomeAzienda(name).getNomeAzienda().equals(name));
		logger.info("EsperienzaRepositoryTest.testSelectByNameAzienda() - END");
		
	}
	@Test
	public void testUpdate() {
		logger.info("EsperienzaRepositoryTest.testUpdate() - START");
		Esperienza currentEsperienza = getFakeEsperienza();
		String descrizione = "modifica descrizione test";
		currentEsperienza.setDescrizione(descrizione);
		esperienzaRT.save(currentEsperienza);
		Assertions.assertTrue(esperienzaRT.findById(currentEsperienza.getId()).isPresent());
		Assertions.assertTrue(esperienzaRT.findById(currentEsperienza.getId()).get().getDescrizione().equals(descrizione));
		logger.info("EsperienzaRepositoryTest.testUpdate() - END");
		
	}
	@Test
	public void testDeleteById() {
		logger.info("EsperienzaRepositoryTest.testDeleteById() - START");
		Esperienza currentEsperienza = getFakeEsperienza();
		Assertions.assertTrue(esperienzaRT.count()==1);
		esperienzaRT.deleteById(currentEsperienza.getId());
		Assertions.assertTrue(esperienzaRT.count()==0);
		logger.info("EsperienzaRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
		logger.info("EsperienzaRepositoryTest.testDeleteAll() - START");
		getFakeEsperienza();
		Assertions.assertTrue(esperienzaRT.count()==1);
		getFakeEsperienza();
		Assertions.assertTrue(esperienzaRT.count()==2);
		esperienzaRT.deleteAll();
		Assertions.assertTrue(esperienzaRT.count()==0);
		logger.info("EsperienzaRepositoryTest.testDeleteAll() - END");
		
	}
}

