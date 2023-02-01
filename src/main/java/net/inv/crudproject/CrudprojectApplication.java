package net.inv.crudproject;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.inv.crudproject.data.entities.Case;
import net.inv.crudproject.service.CaseService;

@SpringBootApplication
public class CrudprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudprojectApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CaseService caseService)
	{
		return args ->
				{
					caseService.saveCase(new Case(new Date(), new Date(), "case1", "case number 1" ));
					caseService.saveCase(new Case(new Date(), new Date(), "case2", "case number 2" ));
					caseService.saveCase(new Case(new Date(), new Date(), "case3", "case number 3" ));
					caseService.saveCase(new Case(new Date(), new Date(), "case4", "case number 4" ));
					caseService.saveCase(new Case(new Date(), new Date(), "case5", "case number 5" ));
					caseService.saveCase(new Case(new Date(), new Date(), "case6", "case number 6" ));
				};
		
	}

}
