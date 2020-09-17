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
import com.monster.persistence.entity.UtenteCompetenza;
import com.monster.repository.AziendaRepository;
import com.monster.repository.UtenteCompetenzaRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UtenteCompetenzaRepositorytest extends AbstractRepositoryTest{

	private static final Logger logger = LoggerFactory.getLogger(UtenteCompetenzaRepositorytest.class);

	@Autowired
	private UtenteCompetenzaRepository utenteCompetenzaRepository;

	@BeforeEach
	@AfterEach
	public void initializeAziendaTest() {
		logger.info("UtenteCompetenzaRepositorytest.initializeAziendaTest - START");		
		utenteCompetenzaRepository.deleteAll();
		//getFakeAzienda();
		logger.info("UtenteCompetenzaRepositorytest.initializeAziendaTest - END");
	}
	@Test
	public void testSelectById() {
    	logger.info("UtenteCompetenzaRepositorytest.testSelectById() - START");    	
    	UtenteCompetenza utenteCompetenza = getFakeUtenteCompetenza();
    	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    	System.out.println(getFakeUtenteCompetenza().toString());
    	logger.info("UtenteCompetenzaRepositorytest.testSelectById() - Debug "+utenteCompetenza.toString());    	
    	Assertions.assertTrue(utenteCompetenzaRepository.findById(utenteCompetenza.getId()).isPresent());	
		logger.info("UtenteCompetenzaRepositorytest.testSelectById() - END");
	}
	
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("UtenteCompetenzaRepositorytest.testSelectAllFilled() - START");    	
    	
    	getFakeUtenteCompetenza();
//    	System.out.println(aziendaRT.count());
    	Assertions.assertTrue(utenteCompetenzaRepository.count() == 1);
    	logger.info("UtenteCompetenzaRepositorytest.testSelectAllFilled() - END");
    }
	
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("UtenteCompetenzaRepositorytest.testSelectAllEmpty() - START");    	
    	Assertions.assertTrue(utenteCompetenzaRepository.count()==0);
		logger.info("UtenteCompetenzaRepositorytest.testSelectAllEmpty() - END");
    }
	
	@Test
	public void testInsert() {
    	logger.info("UtenteCompetenzaRepositorytest.testInsert() - START");    	
    	Assertions.assertTrue(utenteCompetenzaRepository.count()==0);
    	getFakeUtenteCompetenza();
		Assertions.assertTrue(utenteCompetenzaRepository.count()==1);
		logger.info("UtenteCompetenzaRepositorytest.testInsert() - END");
	}
	
	
//	@Test
//	public void testSelectByIdUtente() {
//    	logger.info("UtenteCompetenzaRepositorytest.testSelectByIdUtente() - START");
//
//    	long id = getFakeUtenteCompetenza().getId();
//		Assertions.assertTrue(!utenteCompetenzaRepository.findByUtente_Id(id).isEmpty());	
//		logger.info("UtenteCompetenzaRepositorytest.testSelectByIdUtente() - END");
//	}
//	
//	@Test
//	public void testSelectByNomeCompetenza() {
//    	logger.info("UtenteCompetenzaRepositorytest.testSelectByNomeCompetenza() - START");
//    	getFakeUtenteCompetenza();
//		Assertions.assertTrue(!utenteCompetenzaRepository.findByCompetenza_nome("fakeCompetenza").isEmpty());	
//		logger.info("UtenteCompetenzaRepositorytest.testSelectByNomeCompetenza() - END");
//	}
	
	@Test
	public void testUpdate() {
		logger.info("UtenteCompetenzaRepositorytest.testUpdate() - START");
		UtenteCompetenza currentUtenteCompetenza = getFakeUtenteCompetenza();
		currentUtenteCompetenza.getCompetenza().setDescrizione("descrizione diversa");
		
		utenteCompetenzaRepository.save(currentUtenteCompetenza);
		Assertions.assertTrue(utenteCompetenzaRepository.findById(currentUtenteCompetenza.getId()).isPresent());	
		Assertions.assertTrue(utenteCompetenzaRepository.findById(currentUtenteCompetenza.getId()).get().getCompetenza().getDescrizione().equals("descrizione diversa"));
		logger.info("UtenteCompetenzaRepositorytest.testUpdate() - END");
	}
	
	@Test
	public void testDeleteById() {
    	logger.info("UtenteCompetenzaRepositorytest.testDeleteById() - START");    	
		UtenteCompetenza currentUtenteCompetenza = getFakeUtenteCompetenza();
    	Assertions.assertTrue(utenteCompetenzaRepository.count()==1);
    	utenteCompetenzaRepository.deleteById(currentUtenteCompetenza.getId());
    	Assertions.assertTrue(utenteCompetenzaRepository.count()==0);
    	logger.info("UtenteCompetenzaRepositorytest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
    	logger.info("UtenteCompetenzaRepositorytest.testDeleteAll() - START");    	
    	getFakeUtenteCompetenza();
    	Assertions.assertTrue(utenteCompetenzaRepository.count()==1);
    	getFakeUtenteCompetenza();
    	Assertions.assertTrue(utenteCompetenzaRepository.count()==2);
    	utenteCompetenzaRepository.deleteAll();
		Assertions.assertTrue(utenteCompetenzaRepository.count()==0);
		logger.info("UtenteCompetenzaRepositorytest.testDeleteAll() - END");
	}
	
}
