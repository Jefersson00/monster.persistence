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
import com.monster.persistence.entity.Esperienza;
import com.monster.persistence.entity.Sede;
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
	public void testSelectWithCitta() {
    	logger.info("SedeRepositoryTest.testSelectByCitta() - START");    	
    	Sede currentSede= getFakeSedeWithCitta("milano");
    	logger.info("SedeRepositoryTest.testSelectByCitta() - Debug "+currentSede.toString());    	
    	Assertions.assertTrue(sedeRT.findByCitta(currentSede.getCitta()).get(0).getCitta().equals(currentSede.getCitta()));	
		logger.info("SedeRepositoryTest.testSelectByCitta() - END");
	}
	
	@Test
	public void testSelectWithRegione() {
    	logger.info("SedeRepositoryTest.testSelectByRegione - START");    	
    	Sede currentSede= getFakeSedeWithRegione("sicilia");
    	logger.info("SedeRepositoryTest.testSelectByRegione() - Debug "+currentSede.toString());    	
    	Assertions.assertTrue(sedeRT.findByRegione(currentSede.getRegione()).get(0).getRegione().equals(currentSede.getRegione()));	
		logger.info("SedeRepositoryTest.testSelectByRegione - END");
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
    	logger.info("SedeRepositoryTest.testInsert() - START");    	
    	Assertions.assertTrue(sedeRT.count()==0);
    	getFakeSede();
		Assertions.assertTrue(sedeRT.count()==1);
		logger.info("SedeRepositoryTest.testInsert() - END");
	}
	
	
	@Test
	public void testUpdate() {
		logger.info("SedeRepositoryTest.testUpdate() - START");
		Sede currentSede = getFakeSede();
		String citta = "modifica citta";
		currentSede.setCitta(citta);
		sedeRT.save(currentSede);
		Assertions.assertTrue(sedeRT.findById(currentSede.getId()).isPresent());
		Assertions.assertTrue(sedeRT.findById(currentSede.getId()).get().getCitta().equals(citta));
		logger.info("SedeRepositoryTest.testUpdate() - END");
		
	}
	@Test
	public void testDeleteById() {
		logger.info("SedeRepositoryTest.testDeleteById() - START");
		Sede currentSede= getFakeSede();
		Assertions.assertTrue(sedeRT.count()==1);
		sedeRT.deleteById(currentSede.getId());
		Assertions.assertTrue(sedeRT.count()==0);
		logger.info("SedeRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
		logger.info("SedeRepositoryTest.testDeleteAll() - START");
		getFakeSede();
		Assertions.assertTrue(sedeRT.count()==1);
		getFakeSede();
		Assertions.assertTrue(sedeRT.count()==2);
		sedeRT.deleteAll();
		Assertions.assertTrue(sedeRT.count()==0);
		logger.info("SedeRepositoryTest.testDeleteAll() - END");
		
	}
	
}
