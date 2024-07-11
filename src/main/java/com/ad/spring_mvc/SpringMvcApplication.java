package com.ad.spring_mvc;

import com.ad.spring_mvc.entities.Contrat;
import com.ad.spring_mvc.repositories.ContratRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringMvcApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(ContratRepository contratRepository){
		return args ->{
			for (int i=0;i<10;i++){
				contratRepository.save(new Contrat(null,"Création de compte",new Date(),10+Math.random()*9333,"Hassan",false));
				contratRepository.save(new Contrat(null,"Vente",new Date(),10+Math.random()*320544,"Yassine",false));
				contratRepository.save(new Contrat(null,"Assurance",new Date(),10+Math.random()*680544,"Yasmine",false));
			}

			contratRepository.findAll().forEach(c->{
				System.out.println(c.toString());
			});

		};
	}

}
