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

import com.monster.repository.AziendaRepository;
import com.monster.repository.SedeRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class SedeRepositoryTest extends AbstractRepositoryTest{
	
	
	private static final Logger logger = LoggerFactory.getLogger(SedeRepositoryTest.class);
	
	@Autowired
	SedeRepository sedeRT;
	
	@Autowired
	AziendaRepository aziendaRT;
	
	
	
	
	@BeforeEach
	@AfterEach
	public void initializeSedeTest() {
		logger.info("SedeRepositoryTest.initializeSedeTest - START");
		sedeRT.deleteAll();
		aziendaRT.deleteAll();
		logger.info("SedeRepositoryTest.initializeSedeTest - END");
	}
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("SedeRepositoryTest.testSelectAllFilled() - START");    	
    	getFakeSede();
    	Assertions.assertTrue(sedeRT.count() == 1);
    	logger.info("SedeRepositoryTest.testSelectAllFilled() - END");
    }
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("SedeRepositoryTest.testSelectAllEmpty() - START");    	
    	Assertions.assertTrue(sedeRT.count()==0);
		logger.info("SedeRepositoryTest.testSelectAllEmpty() - END");
    }
	
	@Test
	public void testInsert() {
    	logger.info("AziendaRepositoryTest.testInsert() - START");    	
    	Assertions.assertTrue(sedeRT.count()==0);
    	getFakeSede();
		Assertions.assertTrue(sedeRT.count()==1);
		logger.info("AziendaRepositoryTest.testInsert() - END");
	}
	
}
