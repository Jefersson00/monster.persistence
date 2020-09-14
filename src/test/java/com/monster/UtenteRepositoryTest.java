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
import com.monster.repository.AziendaRepository;
import com.monster.repository.UtenteRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UtenteRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(AziendaRepositoryTest.class);

	@Autowired
	UtenteRepository utenteRT;

	@BeforeEach
	@AfterEach
	public void initializeUtenteTest() {
		logger.info("UtenteRepositoryTest.initializeUtenteTest - START");
		utenteRT.deleteAll();
		getFakeUtente();
		logger.info("UtenteRepositoryTest.initializeUtenteTest - END");
	}

	@Test
	public void testSelectByEmail() {
		logger.info("UtenteRepositoryTest.testSelectByName() - START");

		Utente currentUtente = getFakeUtente();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(currentUtente.toString());
		logger.info("UtenteRepositoryTest.testSelectByName() - Debug " + currentUtente.toString());
		Assertions.assertTrue(utenteRT.findById(currentUtente.getId()).isPresent());
		logger.info("UtenteRepositoryTest.testSelectByName() - END");
	}

}
