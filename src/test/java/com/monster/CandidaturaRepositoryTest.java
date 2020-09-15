package com.monster;
//MarcoBraia marco.braia.mb@gmail.com
//in fase di sviluppo

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

import com.monster.repository.CandidaturaRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CandidaturaRepositoryTest extends AbstractRepositoryTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CandidaturaRepositoryTest.class);

	@Autowired
	private CandidaturaRepository candidaturaRT;
	
	@BeforeEach
	@AfterEach
	public void initializeCandidaturaTest() {
		logger.info("CandidaturaRepositoryTest.initializeCandidaturaTest - START");		
		candidaturaRT.deleteAll();
		logger.info("CandidaturaRepositoryTest.initializeCandidaturaTest - END");
	}
	
	@Test
	void test() {
		Assertions.assertTrue(true);
	}

}
