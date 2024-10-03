package org.alura.table_fipe;

import org.alura.table_fipe.principal.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TableFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TableFipeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.runner();


	}
}
