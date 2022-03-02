package com.example;

import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.example.util.IOUtil.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Day13workshopApplication {
	private static final Logger logger 
		= LoggerFactory.getLogger(Day13workshopApplication.class);

		public static void main(String[] args) {
			SpringApplication app = new SpringApplication(Day13workshopApplication.class);
			DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

			List<String> optsval = appArgs.getOptionValues("dataDir");
		
			if(optsval != null){
				logger.info(optsval.get(0));
				System.out.println(optsval.get(0));
				createDir((String)optsval.get(0));
			
			}else{
			
				logger.warn("No data directory is provided!");
				System.exit(1);
			}
				
			app.run(args);
		}
	
	}
	