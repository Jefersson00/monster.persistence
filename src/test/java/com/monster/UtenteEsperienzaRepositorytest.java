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

import com.monster.persistence.entity.UtenteCompetenza;
import com.monster.persistence.entity.UtenteEsperienza;
import com.monster.repository.UtenteCompetenzaRepository;
import com.monster.repository.UtenteEsperienzaRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UtenteEsperienzaRepositorytest extends AbstractRepositoryTest{
	private static final Logger logger = LoggerFactory.getLogger(UtenteEsperienzaRepositorytest.class);

	@Autowired
	private UtenteEsperienzaRepository utenteEsperienzaRepository;

	@BeforeEach
	@AfterEach
	public void initializeAziendaTest() {
		logger.info("UtenteEsperienzaRepositorytest.initializeAziendaTest - START");		
		utenteEsperienzaRepository.deleteAll();
		//getFakeAzienda();
		logger.info("UtenteEsperienzaRepositorytest.initializeAziendaTest - END");
	}
	@Test
	public void testSelectById() {
    	logger.info("UtenteEsperienzaRepositorytest.testSelectById() - START");    	
    	UtenteEsperienza utenteEsperienza = getFakeUtenteEsperienza();
    	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    	System.out.println(getFakeUtenteEsperienza().toString());
    	logger.info("UtenteEsperienzaRepositorytest.testSelectById() - Debug "+utenteEsperienza.toString());    	
    	Assertions.assertTrue(utenteEsperienzaRepository.findById(utenteEsperienza.getId()).isPresent());	
		logger.info("UtenteEsperienzaRepositorytest.testSelectById() - END");
	}
	
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("UtenteEsperienzaRepositorytest.testSelectAllFilled() - START");    	
    	
    	getFakeUtenteEsperienza();//    	System.out.println(aziendaRT.count());
    	Assertions.assertTrue(utenteEsperienzaRepository.count() == 1);
    	logger.info("UtenteEsperienzaRepositorytest.testSelectAllFilled() - END");
    }
	
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("UtenteEsperienzaRepositorytest.testSelectAllEmpty() - START");    	
    	Assertions.assertTrue(utenteEsperienzaRepository.count()==0);
		logger.info("UtenteEsperienzaRepositorytest.testSelectAllEmpty() - END");
    }
	
	@Test
	public void testInsert() {
    	logger.info("UtenteEsperienzaRepositorytest.testInsert() - START");    	
    	Assertions.assertTrue(utenteEsperienzaRepository.count()==0);
    	getFakeUtenteEsperienza();
		Assertions.assertTrue(utenteEsperienzaRepository.count()==1);
		logger.info("UtenteEsperienzaRepositorytest.testInsert() - END");
	}
	
	
	@Test
	public void testSelectByIdUtente() {
    	logger.info("UtenteEsperienzaRepositorytest.testSelectByIdUtente() - START");

    	long id = getFakeUtenteEsperienza().getId();
		Assertions.assertTrue(!utenteEsperienzaRepository.findByUtente_Id(id).isEmpty());	
		logger.info("UtenteEsperienzaRepositorytest.testSelectByIdUtente() - END");
	}
	
	@Test
	public void testSelectByNomeEsperienza() {
    	logger.info("UtenteCompetenzaRepositorytest.testSelectByNomeCompetenza() - START");
    	getFakeUtenteEsperienza();
		Assertions.assertTrue(!utenteEsperienzaRepository.findByEsperienza_NomeAzienda("fakeAzienda").isEmpty());	
		logger.info("UtenteCompetenzaRepositorytest.testSelectByNomeCompetenza() - END");
	}
	
	@Test
	public void testUpdate() {
		logger.info("UtenteEsperienzaRepositorytest.testUpdate() - START");
		UtenteEsperienza currentUtenteEsperienza = getFakeUtenteEsperienza();
		currentUtenteEsperienza.getEsperienza().setDescrizione("descrizione diversa");
		
		utenteEsperienzaRepository.save(currentUtenteEsperienza);
		Assertions.assertTrue(utenteEsperienzaRepository.findById(currentUtenteEsperienza.getId()).isPresent());	
		Assertions.assertTrue(utenteEsperienzaRepository.findById(currentUtenteEsperienza.getId()).get().getEsperienza().getDescrizione().equals("descrizione diversa"));
		logger.info("UtenteEsperienzaRepositorytest.testUpdate() - END");
	}
	
	@Test
	public void testDeleteById() {
    	logger.info("UtenteEsperienzaRepositorytest.testDeleteById() - START");    	
		UtenteEsperienza currentUtenteEsperienza = getFakeUtenteEsperienza();
    	Assertions.assertTrue(utenteEsperienzaRepository.count()==1);
    	utenteEsperienzaRepository.deleteById(currentUtenteEsperienza.getId());
    	Assertions.assertTrue(utenteEsperienzaRepository.count()==0);
    	logger.info("UtenteEsperienzaRepositorytest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
    	logger.info("UtenteEsperienzaRepositorytest.testDeleteAll() - START");    	
    	getFakeUtenteEsperienza();
    	Assertions.assertTrue(utenteEsperienzaRepository.count()==1);
    	getFakeUtenteEsperienza();
    	Assertions.assertTrue(utenteEsperienzaRepository.count()==2);
    	utenteEsperienzaRepository.deleteAll();
		Assertions.assertTrue(utenteEsperienzaRepository.count()==0);
		logger.info("UtenteEsperienzaRepositorytest.testDeleteAll() - END");
	}

}
