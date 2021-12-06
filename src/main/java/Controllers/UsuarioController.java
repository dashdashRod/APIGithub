package Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Repositorio.UsuarioRepositorio;
import com.example.demo.Usuario;
import GitContent.GitUsuarioContent;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
	UsuarioRepositorio repositorio;
	
	@GetMapping("/Lista")
	public List<Usuario> ListaUsuario(){
		return repositorio.findAll();
	}
	
	@PostMapping("/SalvarUsuario")
	public Usuario SalvarUsuario(@RequestBody Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	@GetMapping("/Lista/{id}")
	public Usuario GetUsuarioById(@PathVariable Long id) {
		return repositorio.getById(id);
	}
	
	@GetMapping("/Lista/{id}/github")
	public String ShowRepos(@PathVariable Long id) {
		Usuario novo_usuario = repositorio.getById(id);
		GitUsuarioContent geet = new GitUsuarioContent();
		List<String> novo = geet.GitFunction(novo_usuario.getGitHub());
		return novo.toString();
	}
	
	@DeleteMapping("/DeletarUsuario/{id}")
	public void DeletarUsuario(@PathVariable Long id) {
	   repositorio.deleteById(id);
	}
}
