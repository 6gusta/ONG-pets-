package com.Crud._gusta;

import com.Crud._gusta.domain.model.CadastroOng;
import com.Crud._gusta.infrastructure.repository.OngCadastroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner createAdmin(OngCadastroRepository repository, PasswordEncoder encoder) {
		return args -> {
			String email = "admin@email.com";
			if (!repository.existsByEmail(email)) {
				CadastroOng admin = new CadastroOng();
				admin.setNome("Admin");
				admin.setEmail(email);
				admin.setSenha(encoder.encode("admin123")); // senha criptografada
				admin.setRole("ADMIN");

				repository.save(admin);
				System.out.println("Administrador padrão criado com sucesso!");
			} else {
				System.out.println("Administrador padrão já existe.");
			}
		};
	}
}
