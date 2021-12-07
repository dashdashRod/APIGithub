package com.Application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name = new String();
	@Column(nullable = false)
	private String login = new String();
	@Column(nullable = false)
	private String Password = new String();
	@Column(nullable = false)
	private String gitHub = new String();
	@Column(nullable = false)
	private String email = new String();
	private Date Data = new Date();
	private final String RegEXPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	private final String NameRegex = "^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$";
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) throws Exception {
		if(ValidarNome(name)) {
			this.name = name;	
		}
		else {
			throw new Exception ("Tamanho de nome invalido ou Características do nome invalidas");
		}
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) throws Exception {
		if(ValidarLogin(login)) {
			this.login = login;
		}
		else {
			throw new Exception ("Login de tamanho zero");
		}
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) throws Exception {
		if(ValidarPassword(password)) {
			Password = password;
		}
		else {
			throw new Exception ("Password de tamanho igual a zero");
		}
	}
	public String getGitHub() {
		return gitHub;
	}
	public void setGitHub(String gitHub) {
		this.gitHub = gitHub;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws Exception {
		if(ValidarEmail(email,RegEXPattern)) {
			this.email = email;
		}
		else {
			throw new Exception("Formato de email invalido");
		}
	}
	public String getData() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return (formato.format(Data));
	}
	
	private boolean ValidarEmail(String Email,String regex) {
		return Pattern.compile(regex).matcher(Email).matches();
	}
	
	private boolean ValidarPassword(String Senha) {
		if(Senha.length() == 0) {
			return false;
		}
		return true;
	}
	private boolean ValidarLogin(String login) {
		if(login.length() == 0) {
			return false;
		}
		return true;
	}
	private boolean ValidarNome(String Nome) {
		if(Nome.length() >= 4 && Pattern.compile(NameRegex).matcher(Nome).matches() == true) {
			return true;
		}
		return false;
	}
}
