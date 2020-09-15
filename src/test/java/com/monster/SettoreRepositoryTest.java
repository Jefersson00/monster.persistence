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

import com.monster.repository.SettoreRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SettoreRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(SettoreRepositoryTest.class);
	
	@Autowired
	private SettoreRepository settoreRT;
	
	@BeforeEach
	@AfterEach
	public void initializeSettoreTest() {
		logger.info("SettoreRepositoryTest.initializeSettoreTest - START");		
		settoreRT.deleteAll();
		//getFakeAzienda();
		logger.info("SettoreRepositoryTest.initializeSettoreTest - END");
	}
	
	@Test
	void test() {
		Assertions.assertTrue(true);
	}

}
