package com.monster;
//@jefersson jeferssonserrano00@gmail.com

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.monster.persistence.entity.Annuncio;
import com.monster.persistence.entity.Azienda;
import com.monster.persistence.entity.Candidatura;
import com.monster.persistence.entity.Competenza;
import com.monster.persistence.entity.Esperienza;
import com.monster.persistence.entity.PercorsoFormativo;
import com.monster.persistence.entity.Sede;
import com.monster.persistence.entity.Settore;
import com.monster.persistence.entity.Utente;
import com.monster.persistence.entity.UtenteCompetenza;
import com.monster.persistence.entity.UtenteEsperienza;
import com.monster.persistence.entity.UtentePercorso;
import com.monster.repository.AnnuncioRepository;
import com.monster.repository.AziendaRepository;
import com.monster.repository.CandidaturaRepository;
import com.monster.repository.CompetenzaRepository;
import com.monster.repository.EsperienzaRepository;
import com.monster.repository.PercorsoFormativoRepository;
import com.monster.repository.SedeRepository;
import com.monster.repository.SettoreRepository;
import com.monster.repository.UtenteCompetenzaRepository;
import com.monster.repository.UtenteEsperienzaRepository;
import com.monster.repository.UtentePercorsoRepository;
import com.monster.repository.UtenteRepository;

public abstract class AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(AbstractRepositoryTest.class);

	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private AziendaRepository aziendaRepository;
	
//	@Autowired
//	private Azienda testAzienda ;
//	
	@Autowired
	private SedeRepository sedeRepository;

	@Autowired
	private SettoreRepository settoreRepository;

	@Autowired
	private EsperienzaRepository esperienzaRepository;
	
	@Autowired
	private AnnuncioRepository annuncioRepository;
	
	@Autowired
	private CandidaturaRepository candidaturaRepository;
	
	@Autowired
	private CompetenzaRepository competenzaRepository;
	
	@Autowired
	private UtenteEsperienzaRepository utenteEsperienzaRepository;
	
	@Autowired
	private UtentePercorsoRepository utentePercorsoRepository;
	
	@Autowired
	private UtenteCompetenzaRepository utenteCompetenzaRepository;
	
	@Autowired
	private PercorsoFormativoRepository percorsoFormativoRepository;
	
	

//--------------Utente-----------
	
	

	/**
	 * atenzione per eventuali modifiche future il numero di telefono puo avere 15
	 * caratteri , da efettuare controllo sul backend e persistence sul fatto che
	 * questo valore avvia meno di 15 caratteri
	 * 
	 */
	
	protected Utente getFakeUtente() {
		logger.info("AbstractRepositoryTest.getFakeUtente - START");
		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeUtente - END");
		return getFakeUtenteWithEmailAndPhone("emailRandom" + random, "" + random);

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
		logger.info("AbstractRepositoryTest.getFakeUtenteWithEmailAndPhone - Debug:" + testUtente.toString());
		logger.debug("AbstractRepositoryTest.getFakeUtenteWithEmailAndPhone - Debug:" + testUtente.getId() + "--"
				+ testUtente.getEmail());

		logger.info("AbstractRepositoryTest.getFakeUtenteWithEmailAndPhone - END");
		return testUtente;

	}

//--------------Azienda-----------

	protected Azienda getFakeAzienda() {
		logger.info("AbstractRepositoryTest.getFakeAzienda - START");
		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeAzienda - END");
		return getFakeAziendaWithNameAndEmail("nameRandom" + random, "emailRandom" + random);

	}

	protected Azienda getFakeAziendaWithEmail(String email) {
		logger.info("AbstractRepositoryTest.getFakeAziendaWithEmail - START");
		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeAziendaWithEmail - END");

		return getFakeAziendaWithNameAndEmail("nameRandom" + random, email);
	}

	protected Azienda getFakeAziendaWithName(String name) {
		logger.info("AbstractRepositoryTest.getFakeAziendaWithName - START");

		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeAziendaWithName - END");

		return getFakeAziendaWithNameAndEmail(name, "emailRandom" + random);
	}

	protected Azienda getFakeAziendaWithNameAndEmail(String name, String email) {
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

//--------------Sede-----------

	protected Sede getFakeSede() {
		logger.info("AbstractRepositoryTest.getFakeSede - START");

		Sede testSede = new Sede();
		int random = (int) (Math.random() * 10000);
		testSede.setCitta("citta" + random);
		testSede.setRegione("Regione" + random);
		testSede.setAzienda(getFakeAzienda());
		sedeRepository.save(testSede);
//		logger.error("AbstractRepositoryTest.getFakeSede - Debug:"+testSede.getId());    	
		logger.info("AbstractRepositoryTest.getFakeSede - END");
		return testSede;
	}
	
	protected Sede getFakeSedeWithCitta(String citta) {
		logger.info("AbstractRepositoryTest.getFakeSedeWithCitta - START");

		Sede testSede = new Sede();
		int random = (int) (Math.random() * 10000);
		testSede.setCitta(citta + random);
		testSede.setRegione("Regione" + random);
		testSede.setAzienda(getFakeAzienda());
		sedeRepository.save(testSede);
//		logger.error("AbstractRepositoryTest.getFakeSede - Debug:"+testSede.getId());    	
		logger.info("AbstractRepositoryTest.getFakeSedeWithCitta - END");
		return testSede;
	}
	
	protected Sede getFakeSedeWithRegione(String regione) {
		logger.info("AbstractRepositoryTest.getFakeSedeWithRegione - START");

		Sede testSede = new Sede();
		int random = (int) (Math.random() * 10000);
		testSede.setCitta("citta" + random);
		testSede.setRegione(regione + random);
		testSede.setAzienda(getFakeAzienda());
		sedeRepository.save(testSede);
//		logger.error("AbstractRepositoryTest.getFakeSede - Debug:"+testSede.getId());    	
		logger.info("AbstractRepositoryTest.getFakeSedeWithRegione - END");
		return testSede;
	}

//--------------Settore-----------

	protected Settore getFakeSettore() {
		logger.info("AbstractRepositoryTest.getFakeSettore - START");
		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeSettore - END");
		return getFakeSettoreWithName("nameRandom" + random);

	}

	protected Settore getFakeSettoreWithName(String name) {
		logger.info("AbstractRepositoryTest.getFakeSettoreWithName - START");
		Settore testSettore = new Settore();
		// int random = (int) (Math.random() * 10000);
		testSettore.setNome(name);
		testSettore.setDescrizione("descrizione settore");
		settoreRepository.save(testSettore);
//		logger.error("AbstractRepositoryTest.getFakeSettoreWithNameAndEmail - Debug:"+testSettore.getId()+"--"+testSettore.getEmail());    	
		logger.info("AbstractRepositoryTest.getFakeSettoreWithName - END");
		return testSettore;
	}

//--------------Esperienza---------------

	protected Esperienza getFakeEsperienza() {
		logger.info("AbstractRepositoryTest.getFakeEspierienza - START");
		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeEspierienza - END");
		return getFakeEsperienzaWithNameAzienda("nameRandom" + random);
	}

	protected Esperienza getFakeEsperienzaWithNameAzienda(String name) {
		logger.info("AbstractRepositoryTest.getFakeEspierienzaWithNameAzienda - START");
		Esperienza testEsperienza = new Esperienza();
		testEsperienza.setNomeAzienda(name);
		testEsperienza.setDescrizione("descrizione");
		esperienzaRepository.save(testEsperienza);
		logger.info("AbstractRepositoryTest.getFakeEspierienzaWithNameAzienda - END");
		return testEsperienza;
	}
	
//-------------------------Annunicio---------------------------
	protected Annuncio getFakeAnnuncio() {
		logger.info("AbstractRepositoryTest.getFakeAnnucio - START");
		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeAnnucio - END");
		return getFakeAnnuncioWithContratto("contratto" + random);

	}

	protected Annuncio getFakeAnnuncioWithContratto(String contratto) {
		logger.info("AbstractRepositoryTest.getFakeUtenteWithContratto - START");

		Annuncio testAnnuncio= new Annuncio();

		testAnnuncio.setDescrizione("descrizione di prova");
		testAnnuncio.setContratto(contratto);
		testAnnuncio.setSettore(getFakeSettore());
		testAnnuncio.setSede(getFakeSede());

		annuncioRepository.save(testAnnuncio);
		logger.info("AbstractRepositoryTest.getFakeUtenteWithContratto - Debug:" + testAnnuncio.toString());
		logger.debug("AbstractRepositoryTest.getFakeUtenteWithContratto - Debug:" + testAnnuncio.getId() + "--");

		logger.info("AbstractRepositoryTest.getFakeUtenteWithContratto - END");
		return testAnnuncio;

	}
	
	
	protected Annuncio getFakeAnnuncioWithDescrizione(String descrizione) {
		logger.info("AbstractRepositoryTest.getFakeAnnuncioWithDescrizione - START");

		Annuncio testAnnuncio= new Annuncio();

		testAnnuncio.setDescrizione(descrizione);
		testAnnuncio.setContratto("contratto");
		testAnnuncio.setSettore(getFakeSettore());
		testAnnuncio.setSede(getFakeSede());

		annuncioRepository.save(testAnnuncio);
		logger.info("AbstractRepositoryTest.getFakeAnnuncioWithDescrizione - Debug:" + testAnnuncio.toString());
		logger.debug("AbstractRepositoryTest.getFakeAnnuncioWithDescrizione - Debug:" + testAnnuncio.getId() + "--");

		logger.info("AbstractRepositoryTest.getFakeAnnuncioWithDescrizione - END");
		return testAnnuncio;

	}
	
	
//--------------Candidatura---------------
	
	protected Candidatura getFakeCandidaturaWithAnnuncioAndUtente(Annuncio annuncio, Utente utente) {
		logger.info("AbstractRepositoryTest.getFakeCandidaturaWithAnnuncioAndUtente - START");
		Candidatura testCandidatura=new Candidatura();
		testCandidatura.setAnnuncio(annuncio);
		testCandidatura.setUtente(utente);
		candidaturaRepository.save(testCandidatura);
		logger.info("AbstractRepositoryTest.getFakeCandidaturaWithAnnuncioAndUtente - Debug:" + testCandidatura.toString());
		logger.debug("AbstractRepositoryTest.getFakeCandidaturaWithAnnuncioAndUtente - Debug:" + testCandidatura.getId() + "--");
		logger.info("AbstractRepositoryTest.getFakeCandidaturaWithAnnuncioAndUtente - END");
		return testCandidatura;	
	}
	
	protected Candidatura getFakeCandidaturaWithAnnuncio(Annuncio annuncio) {
		logger.info("AbstractRepositoryTest.getFakeCandidaturaWithAnnuncio - START");
		Utente utente=getFakeUtente();
		logger.info("AbstractRepositoryTest.getFakeCandidaturaWithAnnuncio - END");
		return getFakeCandidaturaWithAnnuncioAndUtente(annuncio,utente);	
	}
	
	protected Candidatura getFakeCandidaturaWithUtente(Utente utente) {
		logger.info("AbstractRepositoryTest.getFakeCandidaturaWithUtente - START");
		Annuncio annuncio=getFakeAnnuncio();
		logger.info("AbstractRepositoryTest.getFakeCandidaturaWithUtente - END");
		return getFakeCandidaturaWithAnnuncioAndUtente(annuncio,utente);
	}
	
	protected Candidatura getFakeCandidatura() {
		logger.info("AbstractRepositoryTest.getFakeCandidatura - START");
		Annuncio annuncio=getFakeAnnuncio();
		Utente utente=getFakeUtente();
		logger.info("AbstractRepositoryTest.getFakeCandidatura - END");
		return getFakeCandidaturaWithAnnuncioAndUtente(annuncio,utente);
	}
	
//--------------Competenza---------------
	
	protected Competenza getFakeCompetenza() {
		logger.info("AbstractRepositoryTest.getFakeCompetenza - START");
		int random = (int) (Math.random() * 10000);
		logger.info("AbstractRepositoryTest.getFakeCompetenza - END");
		return getFakeCompetenzaWithName("nameRandom" + random);

	}

	protected Competenza getFakeCompetenzaWithName(String name) {
		logger.info("AbstractRepositoryTest.getFakeCompetenzaWithName - START");
		Competenza testCompetenza = new Competenza();
		testCompetenza.setNome(name);
		testCompetenza.setDescrizione("descrizione competenza");
		competenzaRepository.save(testCompetenza);  	
		logger.info("AbstractRepositoryTest.getFakeCompetenzaWithName - END");
		return testCompetenza;
	}
	//--------------UtenteCompetenza-----------
	
	protected UtenteCompetenza getFakeUtenteCompetenzaWithUtenteAndCompetenza(Utente utente, Competenza competenza) {
		logger.info("AbstractRepositoryTest.getFakeUtenteCompetenzaWithUtenteAndCompetenza - START");
		UtenteCompetenza testUtenteCompetenza=new UtenteCompetenza();
		testUtenteCompetenza.setCompetenza(competenza);
		testUtenteCompetenza.setUtente(utente);
		utenteCompetenzaRepository.save(testUtenteCompetenza);
		logger.info("AbstractRepositoryTest.getFakeUtenteCompetenzaWithUtenteAndCompetenza - Debug:" + testUtenteCompetenza.toString());
		logger.debug("AbstractRepositoryTest.getFakeUtenteCompetenzaWithUtenteAndCompetenza - Debug:" + testUtenteCompetenza.getId() + "--");
		logger.info("AbstractRepositoryTest.getFakeUtenteCompetenzaWithUtenteAndCompetenza - END");
		return testUtenteCompetenza;	
	}
	
	protected UtenteCompetenza getFakeUtenteCompetenzaWithCompetenza(Competenza competenza) {
		logger.info("AbstractRepositoryTest.getFakeUtenteCompetenzaWithAnnuncio - START");
		Utente utente= getFakeUtente();
		logger.info("AbstractRepositoryTest.getFakeUtenteCompetenzaWithAnnuncio - END");
		return getFakeUtenteCompetenzaWithUtenteAndCompetenza(utente, competenza);	
	}
	
	protected UtenteCompetenza getFakeUtenteCompetenzaWithUtente(Utente utente) {
		logger.info("AbstractRepositoryTest.getFakeUtenteCompetenzaWithUtente - START");
		Competenza competenza= getFakeCompetenza();
		logger.info("AbstractRepositoryTest.getFakeUtenteCompetenzaWithUtente - END");
		return getFakeUtenteCompetenzaWithUtenteAndCompetenza(utente, competenza);
	}
	
	protected UtenteCompetenza getFakeUtenteCompetenza() {
		logger.info("AbstractRepositoryTest.getFakeUtenteCompetenza - START");
		Utente utente=getFakeUtente();
		Competenza competenza=getFakeCompetenza();
		logger.info("AbstractRepositoryTest.getFakeUtenteCompetenza - END");
		return getFakeUtenteCompetenzaWithUtenteAndCompetenza(utente, competenza);
	}
	
	//--------------UtenteEsperienza-----------
	
	protected UtenteEsperienza getFakeUtenteEsperienzaWithUtenteAndEsperienza(Utente utente, Esperienza esperienza) {
		logger.info("AbstractRepositoryTest.getFakeUtenteEsperienzaWithUtenteAndEsperienza - START");
		UtenteEsperienza testUtenteEsperienza=new UtenteEsperienza();
		testUtenteEsperienza.setEsperienza(esperienza);
		testUtenteEsperienza.setUtente(utente);
		Date d= new Date();
		testUtenteEsperienza.setDataInizio(d);
		utenteEsperienzaRepository.save(testUtenteEsperienza);
		logger.info("AbstractRepositoryTest.getFakeUtenteEsperienzaWithUtenteAndEsperienza - Debug:" + testUtenteEsperienza.toString());
		logger.debug("AbstractRepositoryTest.getFakeUtenteEsperienzaWithUtenteAndEsperienza - Debug:" + testUtenteEsperienza.getId() + "--");
		logger.info("AbstractRepositoryTest.getFakeUtenteEsperienzaWithUtenteAndEsperienza - END");
		return testUtenteEsperienza;	
	}
	
	protected UtenteEsperienza getFakeUtenteEsperienzaWithEsperienza(Esperienza esperienza) {
		logger.info("AbstractRepositoryTest.getFakeUtenteEsperienzaWithEsperienza - START");
		Utente utente= getFakeUtente();
		logger.info("AbstractRepositoryTest.getFakeUtenteEsperienzaWithEsperienza - END");
		return getFakeUtenteEsperienzaWithUtenteAndEsperienza(utente, esperienza);	
	}
	
	protected UtenteEsperienza getFakeUtenteEsperienzaWithUtente(Utente utente) {
		logger.info("AbstractRepositoryTest.getFakeUtenteEsperienzaWithUtente - START");
		Esperienza esperienza= getFakeEsperienza();
		logger.info("AbstractRepositoryTest.getFakeUtenteEsperienzaWithUtente - END");
		return getFakeUtenteEsperienzaWithUtenteAndEsperienza(utente, esperienza);
	}
	
	protected UtenteEsperienza getFakeUtenteEsperienza() {
		logger.info("AbstractRepositoryTest.getFakeUtenteEsperienza - START");
		Utente utente=getFakeUtente();
		Esperienza esperienza=getFakeEsperienza();
		logger.info("AbstractRepositoryTest.getFakeUtenteEsperienza - END");
		return getFakeUtenteEsperienzaWithUtenteAndEsperienza(utente, esperienza);
	}
	
	//--------------UtentePercorso-----------
	protected UtentePercorso getFakeUtentePercorsoWithUtenteAndPercorso(Utente utente, PercorsoFormativo percorsoFormativo) {
		logger.info("AbstractRepositoryTest.getFakeUtentePercorsoWithUtenteAndPercorso - START");
		UtentePercorso testUtentePercorso=new UtentePercorso();
		testUtentePercorso.setPercorsoFormativo(percorsoFormativo);
		testUtentePercorso.setUtente(utente);
		utentePercorsoRepository.save(testUtentePercorso);
		logger.info("AbstractRepositoryTest.getFakeUtentePercorsoWithUtenteAndPercorso - Debug:" + testUtentePercorso.toString());
		logger.debug("AbstractRepositoryTest.getFakeUtentePercorsoWithUtenteAndPercorso - Debug:" + testUtentePercorso.getId() + "--");
		logger.info("AbstractRepositoryTest.getFakeUtentePercorsoWithUtenteAndPercorso - END");
		return testUtentePercorso;	
	}
	
	protected UtentePercorso getFakeUtentePercorsoWithPercorso(PercorsoFormativo percorsoFormativo) {
		logger.info("AbstractRepositoryTest.getFakeUtentePercorsoWithPercorso - START");
		Utente utente= getFakeUtente();
		logger.info("AbstractRepositoryTest.getFakeUtentePercorsoWithPercorso - END");
		return getFakeUtentePercorsoWithUtenteAndPercorso(utente, percorsoFormativo);	
	}
	
	protected UtentePercorso getFakeUtentePercorsoWithUtente(Utente utente) {
		logger.info("AbstractRepositoryTest.getFakeUtentePercorsoWithUtente - START");
		PercorsoFormativo percorsoFormativo= getFakePercorsoFormativo();
		logger.info("AbstractRepositoryTest.getFakeUtentePercorsoWithUtente - END");
		return getFakeUtentePercorsoWithUtenteAndPercorso(utente, percorsoFormativo);
	}
	
	protected UtentePercorso getFakeUtentePercorso() {
		logger.info("AbstractRepositoryTest.getFakeUtentePercorso - START");
		Utente utente=getFakeUtente();
		PercorsoFormativo percorsoFormativo=getFakePercorsoFormativo();
		logger.info("AbstractRepositoryTest.getFakeUtentePercorso - END");
		return getFakeUtentePercorsoWithUtenteAndPercorso(utente, percorsoFormativo);
	}
	//------------------------PercorsoFormativo-------------------------
		protected PercorsoFormativo getFakePercorsoFormativo() {
			logger.info("AbstractRepositoryTest.getFakePercorsoFormativo - START");
			int random = (int) (Math.random() * 10000);
			logger.info("AbstractRepositoryTest.getFakePercorsoFormativo - END");
			return getFakePercorsoFormativoWithFormazione("nameRandom" + random);
		}

		protected PercorsoFormativo getFakePercorsoFormativoWithFormazione(String formazione) {
			logger.info("AbstractRepositoryTest.getFakePercorsoFormativoWithFormazione - START");
			PercorsoFormativo testPercorsoFormativo = new PercorsoFormativo();
			testPercorsoFormativo.setFormazione(formazione);
			testPercorsoFormativo.setDescrizione("descrizione");
			percorsoFormativoRepository.save(testPercorsoFormativo);
			logger.info("AbstractRepositoryTest.getFakePercorsoFormativoWithFormazione - END");
			return testPercorsoFormativo;
	}
}
