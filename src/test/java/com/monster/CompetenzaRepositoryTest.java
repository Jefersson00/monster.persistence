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

import com.monster.persistence.entity.Competenza;
import com.monster.repository.CompetenzaRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CompetenzaRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(CompetenzaRepositoryTest.class);
	
	@Autowired
	private CompetenzaRepository competenzaRT;
	
	@BeforeEach
	@AfterEach
	public void initializeCompetenzaTest() {
		logger.info("CompetenzaRepositoryTest.initializeCompetenzaTest - START");		
		competenzaRT.deleteAll();
		logger.info("CompetenzaRepositoryTest.initializeCompetenzaTest - END");
	}
	
	@Test
	public void testSelectById() {
    	logger.info("CompetenzaRepositoryTest.testSelectById() - START");    	
    	Competenza currentCompetenza = getFakeCompetenza();
    	logger.info("CompetenzaRepositoryTest.testSelectById() - Debug "+getFakeCompetenza().toString());    	
    	logger.info("CompetenzaRepositoryTest.testSelectById() - Debug "+currentCompetenza.toString());    	
    	Assertions.assertTrue(competenzaRT.findById(currentCompetenza.getId()).isPresent());	
		logger.info("CompetenzaRepositoryTest.testSelectById() - END");
	}
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("CompetenzaRepositoryTest.testSelectAllFilled() - START");    	
    	getFakeCompetenza();
    	Assertions.assertTrue(competenzaRT.count() == 1);
    	logger.info("CompetenzaRepositoryTest.testSelectAllFilled() - END");
    }
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("CompetenzaRepositoryTest.testSelectAllEmpty() - START");    	
    	Assertions.assertTrue(competenzaRT.count()==0);
		logger.info("CompetenzaRepositoryTest.testSelectAllEmpty() - END");
    }
	
	
	@Test
	public void testInsert() {
    	logger.info("CompetenzaRepositoryTest.testInsert() - START");    	
    	Assertions.assertTrue(competenzaRT.count()==0);
    	getFakeCompetenza();
		Assertions.assertTrue(competenzaRT.count()==1);
		logger.info("CompetenzaRepositoryTest.testInsert() - END");
	}
	
	
	@Test
	public void testSelectByName() {
    	logger.info("CompetenzaRepositoryTest.testSelectByName() - START");
    	int random = (int) (Math.random() * 10000);
    	String name = "programmazione" + random ;
    	getFakeCompetenzaWithName(name);
		Assertions.assertTrue(competenzaRT.findByNome(name).getNome().equals(name));	
		logger.info("CompetenzaRepositoryTest.testSelectByName() - END");
	}
	
	
	@Test
	public void testUpdate() {
		logger.info("CompetenzaRepositoryTest.testUpdate() - START");
		Competenza currentCompetenza = getFakeCompetenza();
		String descrizione ="modifica descrizione test";
		currentCompetenza.setDescrizione(descrizione);
		competenzaRT.save(currentCompetenza);
		Assertions.assertTrue(competenzaRT.findById(currentCompetenza.getId()).isPresent());	
		Assertions.assertTrue(competenzaRT.findById(currentCompetenza.getId()).get().getDescrizione().equals(descrizione));
		logger.info("CompetenzaRepositoryTest.testUpdate() - END");
	}
	
	@Test
	public void testDeleteById() {
    	logger.info("CompetenzaRepositoryTest.testDeleteById() - START");    	
    	Competenza currentCompetenza = getFakeCompetenza();
    	Assertions.assertTrue(competenzaRT.count()==1);
    	competenzaRT.deleteById(currentCompetenza.getId());
    	Assertions.assertTrue(competenzaRT.count()==0);
    	logger.info("CompetenzaRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
    	logger.info("CompetenzaRepositoryTest.testDeleteAll() - START");    	
    	getFakeCompetenza();
    	Assertions.assertTrue(competenzaRT.count()==1);
    	getFakeCompetenza();
    	Assertions.assertTrue(competenzaRT.count()==2);
    	competenzaRT.deleteAll();
		Assertions.assertTrue(competenzaRT.count()==0);
		logger.info("CompetenzaRepositoryTest.testDeleteAll() - END");
	}


}
