package org.estudo.aluraSpring001;


import org.estudo.aluraSpring001.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraSpring001Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AluraSpring001Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibirMenu();
	}
}
