package com.monster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.monster.persistence.entity.Azienda;
import com.monster.repository.AziendaRepository;


//@jefersson jeferssonserrano00@gmail.com
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AziendaRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(AziendaRepositoryTest.class);

	@Autowired
	private AziendaRepository aziendaRT;

	@BeforeEach
	@AfterEach
	public void initializeAziendaTest() {
		logger.info("AziendaRepositoryTest.initializeAziendaTest - START");		
		aziendaRT.deleteAll();
//		getFakeAzienda();
		logger.info("AziendaRepositoryTest.initializeAziendaTest - END");
	}

	@Test
	public void testSelectById() {
    	logger.info("AziendaRepositoryTest.testSelectById() - START");    	
    	Azienda currentAzienda = getFakeAzienda();
    	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    	System.out.println(getFakeAzienda().toString());
    	logger.info("AziendaRepositoryTest.testSelectById() - Debug "+currentAzienda.toString());    	
    	Assertions.assertTrue(aziendaRT.findById(currentAzienda.getId()).isPresent());	
		logger.info("AziendaRepositoryTest.testSelectById() - END");
	}
	
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("AziendaRepositoryTest.testSelectAllFilled() - START");    	
    	
    	getFakeAzienda();
    	System.out.println(aziendaRT.count());
    	Assertions.assertTrue(aziendaRT.count() == 1);
    	logger.info("AziendaRepositoryTest.testSelectAllFilled() - END");
    }
	
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("AziendaRepositoryTest.testSelectAllEmpty() - START");    	
    	Assertions.assertTrue(aziendaRT.count()==0);
		logger.info("AziendaRepositoryTest.testSelectAllEmpty() - END");
    }
	
	@Test
	public void testInsert() {
    	logger.info("AziendaRepositoryTest.testInsert() - START");    	
    	Assertions.assertTrue(aziendaRT.count()==0);
    	getFakeAzienda();
		Assertions.assertTrue(aziendaRT.count()==1);
		logger.info("AziendaRepositoryTest.testInsert() - END");
	}
	
	
	@Test
	public void testSelectByName() {
    	logger.info("AziendaRepositoryTest.testSelectByName() - START");
    	int random = (int) (Math.random() * 10000);
    	String name = "jefersson" + random ;
    	getFakeAziendaWithName(name);
		Assertions.assertTrue(aziendaRT.findByNome(name).getNome().equals(name));	
		logger.info("AziendaRepositoryTest.testSelectByName() - END");
	}
	
	@Test
	public void testSelectByEmail() {
    	logger.info("AziendaRepositoryTest.testSelectByEmail() - START");
    	int random = (int) (Math.random() * 10000);
    	String email = "jeferssonserranotest@gmail" + random ;
    	getFakeAziendaWithEmail(email);
		Assertions.assertTrue(aziendaRT.findByEmail(email).getEmail().equals(email));	
		logger.info("AziendaRepositoryTest.testSelectByEmail() - END");
	}
	
	@Test
	public void testUpdate() {
		logger.info("AziendaRepositoryTest.testUpdate() - START");
		Azienda currentAzienda = getFakeAzienda();
		String descrizione ="modifica descrizione test";
		currentAzienda.setDescrizione(descrizione);
		aziendaRT.save(currentAzienda);
		Assertions.assertTrue(aziendaRT.findById(currentAzienda.getId()).isPresent());	
		Assertions.assertTrue(aziendaRT.findById(currentAzienda.getId()).get().getDescrizione().equals(descrizione));
		logger.info("AziendaRepositoryTest.testUpdate() - END");
	}
	
	@Test
	public void testDeleteById() {
    	logger.info("AziendaRepositoryTest.testDeleteById() - START");    	
    	Azienda currentAzienda = getFakeAzienda();
    	Assertions.assertTrue(aziendaRT.count()==1);
    	aziendaRT.deleteById(currentAzienda.getId());
    	Assertions.assertTrue(aziendaRT.count()==0);
    	logger.info("AziendaRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
    	logger.info("AziendaRepositoryTest.testDeleteAll() - START");    	
    	getFakeAzienda();
    	Assertions.assertTrue(aziendaRT.count()==1);
    	getFakeAzienda();
    	Assertions.assertTrue(aziendaRT.count()==2);
    	aziendaRT.deleteAll();
		Assertions.assertTrue(aziendaRT.count()==0);
		logger.info("AziendaRepositoryTest.testDeleteAll() - END");
	}

}