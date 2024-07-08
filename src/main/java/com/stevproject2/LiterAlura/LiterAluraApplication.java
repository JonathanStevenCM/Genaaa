package com.stevproject2.LiterAlura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stevproject2.LiterAlura.principal.Principal;
import com.stevproject2.LiterAlura.repository.LibroRepository;



@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner  {

	@Autowired
	private LibroRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraElMenu();
	}

}
