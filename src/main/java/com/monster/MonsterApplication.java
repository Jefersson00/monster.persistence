package com.monster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



/**
 * 
 * Spring application main class.
 * 
 * 
 * @author jeferssonserrano00@gmail.com
 *
 */

@SpringBootApplication
public class MonsterApplication {
	private static final Logger logger = LoggerFactory.getLogger(MonsterApplication.class);
	public static void main(String[] args) {
		logger.info("APPLICATION IS STARTING!!!");		
		ApplicationContext applicationContext = 
				SpringApplication.run(MonsterApplication.class, args);
		
		for (String name : applicationContext.getBeanDefinitionNames()) {
			logger.info(name);
		}
		logger.info("APPLICATION STARTED!!!!!!");
	}

}
