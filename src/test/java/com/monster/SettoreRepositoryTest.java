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

import com.monster.persistence.entity.Settore;
import com.monster.repository.SettoreRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SettoreRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(SettoreRepositoryTest.class);
	
	@Autowired
	private SettoreRepository settoreRT;
	
	@BeforeEach
	@AfterEach
	public void initializeSettoreTest() {
		logger.info("SettoreRepositoryTest.initializeSettoreTest - START");		
		settoreRT.deleteAll();
		//getFakeSettore();
		logger.info("SettoreRepositoryTest.initializeSettoreTest - END");
	}
	
	@Test
	public void testSelectById() {
    	logger.info("SettoreRepositoryTest.testSelectById() - START");    	
    	Settore currentSettore = getFakeSettore();
    	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    	System.out.println(getFakeSettore().toString());
    	logger.info("SettoreRepositoryTest.testSelectById() - Debug "+currentSettore.toString());    	
    	Assertions.assertTrue(settoreRT.findById(currentSettore.getId()).isPresent());	
		logger.info("SettoreRepositoryTest.testSelectById() - END");
	}
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("SettoreRepositoryTest.testSelectAllFilled() - START");    	
    	getFakeSettore();
    	Assertions.assertTrue(settoreRT.count() == 1);
    	logger.info("SettoreRepositoryTest.testSelectAllFilled() - END");
    }
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("SettoreRepositoryTest.testSelectAllEmpty() - START");    	
    	Assertions.assertTrue(settoreRT.count()==0);
		logger.info("SettoreRepositoryTest.testSelectAllEmpty() - END");
    }
	
	
	@Test
	public void testInsert() {
    	logger.info("SettoreRepositoryTest.testInsert() - START");    	
    	Assertions.assertTrue(settoreRT.count()==0);
    	getFakeSettore();
		Assertions.assertTrue(settoreRT.count()==1);
		logger.info("SettoreRepositoryTest.testInsert() - END");
	}
	
	
	@Test
	public void testSelectByName() {
    	logger.info("SettoreRepositoryTest.testSelectByName() - START");
    	int random = (int) (Math.random() * 10000);
    	String name = "programmazione" + random ;
    	getFakeSettoreWithName(name);
		Assertions.assertTrue(settoreRT.findByNome(name).getNome().equals(name));	
		logger.info("SettoreRepositoryTest.testSelectByName() - END");
	}
	
	
	@Test
	public void testUpdate() {
		logger.info("SettoreRepositoryTest.testUpdate() - START");
		Settore currentSettore = getFakeSettore();
		String descrizione ="modifica descrizione test";
		currentSettore.setDescrizione(descrizione);
		settoreRT.save(currentSettore);
		Assertions.assertTrue(settoreRT.findById(currentSettore.getId()).isPresent());	
		Assertions.assertTrue(settoreRT.findById(currentSettore.getId()).get().getDescrizione().equals(descrizione));
		logger.info("SettoreRepositoryTest.testUpdate() - END");
	}
	
	@Test
	public void testDeleteById() {
    	logger.info("SettoreRepositoryTest.testDeleteById() - START");    	
    	Settore currentSettore = getFakeSettore();
    	Assertions.assertTrue(settoreRT.count()==1);
    	settoreRT.deleteById(currentSettore.getId());
    	Assertions.assertTrue(settoreRT.count()==0);
    	logger.info("SettoreRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
    	logger.info("SettoreRepositoryTest.testDeleteAll() - START");    	
    	getFakeSettore();
    	Assertions.assertTrue(settoreRT.count()==1);
    	getFakeSettore();
    	Assertions.assertTrue(settoreRT.count()==2);
    	settoreRT.deleteAll();
		Assertions.assertTrue(settoreRT.count()==0);
		logger.info("SettoreRepositoryTest.testDeleteAll() - END");
	}
	

}
