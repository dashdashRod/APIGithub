package com.Application.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Application.Usuario;
import com.Application.GitContent.GitUsuarioContent;
import com.Application.Repositorio.UsuarioRepositorio;

@RestController
@RequestMapping(value = "/Usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	@GetMapping(value = "/Lista")
	public List<Usuario> ListaUsuario(){
		return repositorio.findAll();
	}
	
	@PostMapping(value = "/SalvarUsuario")
	public Usuario SalvarUsuario1(@RequestBody Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	
	@GetMapping(value = "/Lista/{id}")
	public Usuario GetUsuarioById(@PathVariable Long id) {
		return repositorio.findById(id).get();
	}
	
	@GetMapping(value = "/Lista/{id}/github")
	public String ShowRepos(@PathVariable Long id) {
		Usuario novo_usuario = repositorio.findById(id).get();
		GitUsuarioContent geet = new GitUsuarioContent();
		List<String> novo = geet.GitFunction(novo_usuario.getGitHub());
		return novo.toString();
	}
	
	@DeleteMapping(value = "/DeletarUsuario/{id}")
	public void DeletarUsuario(@PathVariable Long id) {
	   repositorio.deleteById(id);
	}
}
