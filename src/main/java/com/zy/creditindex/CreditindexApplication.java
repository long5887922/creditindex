package com.zy.creditindex;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling 
public class CreditindexApplication  {
	protected static final Logger logger = LoggerFactory.getLogger(CreditindexApplication.class);

	public static void main(String[] args) {
		logger.info("*********************START********************");
		SpringApplication.run(CreditindexApplication.class, args);
		logger.info("*********************END**********************");
	}
}
