package com.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"Controllers.UsuarioController","Repositorio.UsuarioRepositorio"})
@ComponentScan("com")
public class ApiRestGitHubJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestGitHubJavaApplication.class, args);
	}
}
