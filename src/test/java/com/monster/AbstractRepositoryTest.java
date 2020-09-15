package com.monster;
//@jefersson jeferssonserrano00@gmail.com

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.monster.persistence.entity.Annuncio;
import com.monster.persistence.entity.Azienda;
import com.monster.persistence.entity.Sede;
import com.monster.persistence.entity.Settore;
import com.monster.persistence.entity.Utente;
import com.monster.repository.AnnuncioRepository;
import com.monster.repository.AziendaRepository;
import com.monster.repository.SedeRepository;
import com.monster.repository.UtenteRepository;

public abstract class AbstractRepositoryTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractRepositoryTest.class);
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private AziendaRepository aziendaRepository;
	
	@Autowired
	private SedeRepository sedeRepository;


	protected Utente getFakeUtente() {
		logger.info("AbstractRepositoryTest.getFakeUtente - START");    	
		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeUtente - END");    	
		return getFakeUtenteWithEmailAndPhone("emailRandom"+random,""+random);
		
	}
	
	
	protected Utente getFakeUtenteWithEmailAndPhone(String email, String numeroTelefono) {
		logger.info("AbstractRepositoryTest.getFakeUtenteWithEmailAndPhone - START");    	

		Utente testUtente = new Utente();
		
		testUtente.setEmail(email);
		testUtente.setTelefono(numeroTelefono);
		testUtente.setNome("nomeProva");
		testUtente.setCognome("cognome PRova");
		testUtente.setPassword("passProva");
		
		utenteRepository.save(testUtente);
		System.out.println(testUtente.toString());
		logger.error("AbstractRepositoryTest.getFakeUtenteWithEmailAndPhone - Debug:"+testUtente.getId()+"--"+testUtente.getEmail());    	
		
		
		logger.info("AbstractRepositoryTest.getFakeUtenteWithEmailAndPhone - END");    	
		return testUtente;
		
	}
	
	protected Azienda getFakeAzienda() {
		logger.info("AbstractRepositoryTest.getFakeAzienda - START");    	
		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeAzienda - END");    	
		return getFakeAziendaWithNameAndEmail("nameRandom"+random,"emailRandom"+random);
		
	}
	
	protected Azienda getFakeAziendaWithEmail(String email) {
		logger.info("AbstractRepositoryTest.getFakeAziendaWithEmail - START");    	
		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeAziendaWithEmail - END");    	

		return getFakeAziendaWithNameAndEmail("nameRandom"+random,email);
	}
	
	protected Azienda getFakeAziendaWithName(String name) {
		logger.info("AbstractRepositoryTest.getFakeAziendaWithName - START");    	

		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeAziendaWithName - END");    	

		return getFakeAziendaWithNameAndEmail(name,"emailRandom"+random);
	}
	
	protected Azienda getFakeAziendaWithNameAndEmail(String name,String email) {
		logger.info("AbstractRepositoryTest.getFakeAziendaWithNameAndEmail - START");    	

		Azienda testAzienda = new Azienda();
		int random = (int) (Math.random() * 10000);
		testAzienda.setEmail(email);
		testAzienda.setPassword("pswTest");
		testAzienda.setNome(name);
		testAzienda.setDescrizione("descrizione azienda");
		testAzienda.setNumeroDipendenti(random);
		testAzienda.setLink("testLinkAzienda");
		testAzienda.setLogo("testLogoAzienda");
		long timestamp = System.currentTimeMillis();
        Date date = new Date(timestamp);
		testAzienda.setAnnoFondazione(date);
		testAzienda.setSettore("testSettoreAzienda");
		aziendaRepository.save(testAzienda);
//		logger.error("AbstractRepositoryTest.getFakeAziendaWithNameAndEmail - Debug:"+testAzienda.getId()+"--"+testAzienda.getEmail());    	
		
		
		logger.info("AbstractRepositoryTest.getFakeAziendaWithNameAndEmail - END");    	
		return testAzienda;
	}
	
	protected Sede getFakeSede() {
		logger.info("AbstractRepositoryTest.getFakeSede - START");    	

		Sede testSede = new Sede();
		int random = (int) (Math.random() * 10000);
		testSede.setCitta("citta"+random);
		testSede.setRegione("Regione"+random);
		testSede.setAzienda(getFakeAzienda());
		sedeRepository.save(testSede);
//		logger.error("AbstractRepositoryTest.getFakeSede - Debug:"+testSede.getId());    	
		logger.info("AbstractRepositoryTest.getFakeSede - END");    	
		return testSede;
	}
	
}
