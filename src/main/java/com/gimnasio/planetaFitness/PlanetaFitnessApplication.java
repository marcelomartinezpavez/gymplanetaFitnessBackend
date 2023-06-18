package com.gimnasio.planetaFitness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@SpringBootApplication
//@ComponentScan({"com.delivery.request"})
//@EntityScan("com.delivery.domain")
@EnableJpaRepositories("com.gimnasio.planetaFitness.repository")
public class PlanetaFitnessApplication {

	//@Autowired
	//ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlanetaFitnessApplication.class, args);
	}

}
