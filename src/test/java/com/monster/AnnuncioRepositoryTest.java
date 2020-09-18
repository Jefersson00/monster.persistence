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

import com.monster.persistence.entity.Annuncio;
import com.monster.persistence.entity.Azienda;
import com.monster.repository.AnnuncioRepository;
import com.monster.repository.AziendaRepository;
import com.monster.repository.SedeRepository;
import com.monster.repository.SettoreRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AnnuncioRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(AnnuncioRepositoryTest.class);

	@Autowired
	private AnnuncioRepository annuncioRT;

	@Autowired
	private SettoreRepository settoreRT;

	@Autowired
	private SedeRepository sedeRT;

	@BeforeEach
	@AfterEach
	public void initializeAnnuncioTest() {
		logger.info("AnnuncioRepositoryTest.initializeAnnuncioTest - START");
		annuncioRT.deleteAll();
		sedeRT.deleteAll();
		settoreRT.deleteAll();
		logger.info("AnnuncioRepositoryTest.initializeAnnuncioTest - END");
	}

	@Test
	public void testInsert() {
		logger.info("AnnuncioRepositoryTest.testInsert() - START");
		Assertions.assertTrue(annuncioRT.count() == 0);
		getFakeAnnuncio();
		Assertions.assertTrue(annuncioRT.count() == 1);
		logger.info("AnnuncioRepositoryTest.testInsert() - END");
	}

	@Test
	public void testSelectById() {
		logger.info("AnnuncioRepositoryTest.testSelectById() - START");
		Annuncio currentAnnuncio = getFakeAnnuncio();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(getFakeAzienda().toString());
		logger.info("AnnuncioRepositoryTest.testSelectById() - Debug " + currentAnnuncio.toString());
		Assertions.assertTrue(annuncioRT.findById(currentAnnuncio.getId()).isPresent());
		logger.info("AnnuncioRepositoryTest.testSelectById() - END");
	}

	@Test
	public void testSelectAllFilled() {
		logger.info("AnnuncioRepositoryTest.testSelectAllFilled() - START");

		getFakeAnnuncio();
		System.out.println(annuncioRT.count());
		Assertions.assertTrue(annuncioRT.count() == 1);
		logger.info("AnnuncioRepositoryTest.testSelectAllFilled() - END");
	}

	@Test
	public void testSelectAllEmpty() {
		logger.info("AnnuncioRepositoryTest.testSelectAllEmpty() - START");
		Assertions.assertTrue(annuncioRT.count() == 0);
		logger.info("AnnuncioRepositoryTest.testSelectAllEmpty() - END");
	}

	@Test
	public void testSelectByContratto() {
		logger.info("AnnuncioRepositoryTest.testSelectByContratto() - START");
		int random = (int) (Math.random() * 10000);
		String contratto = "contratto" + random;
		getFakeAnnuncioWithContratto(contratto);

		// findByContratto restituisce una lista non un oggetto
		Assertions.assertTrue(annuncioRT.findByContratto(contratto).get(0).getContratto().equals(contratto));
		logger.info("AnnuncioRepositoryTest.testSelectByContratto() - END");
	}

	@Test
	public void testUpdate() {
		logger.info("AnnuncioRepositoryTest.testUpdate() - START");
		Annuncio currentAnnuncio = getFakeAnnuncio();
		String descrizione = "modifica descrizione test";
		currentAnnuncio.setDescrizione(descrizione);
		annuncioRT.save(currentAnnuncio);
		Assertions.assertTrue(annuncioRT.findById(currentAnnuncio.getId()).isPresent());
		Assertions.assertTrue(annuncioRT.findById(currentAnnuncio.getId()).get().getDescrizione().equals(descrizione));
		logger.info("AnnuncioRepositoryTest.testUpdate() - END");
	}

	@Test
	public void testDeleteById() {
		logger.info("AnnuncioRepositoryTest.testDeleteById() - START");
		Annuncio currentAnnuncio = getFakeAnnuncio();
		Assertions.assertTrue(annuncioRT.count() == 1);
		annuncioRT.deleteById(currentAnnuncio.getId());
		Assertions.assertTrue(annuncioRT.count() == 0);
		logger.info("AnnuncioRepositoryTest.testDeleteById() - END");
	}

	@Test
	public void testDeleteAll() {
		logger.info("AnnuncioRepositoryTest.testDeleteAll() - START");
		getFakeAnnuncio();
		Assertions.assertTrue(annuncioRT.count() == 1);
		getFakeAnnuncio();
		Assertions.assertTrue(annuncioRT.count() == 2);
		annuncioRT.deleteAll();
		Assertions.assertTrue(annuncioRT.count() == 0);
		logger.info("AnnuncioRepositoryTest.testDeleteAll() - END");
	}

}
