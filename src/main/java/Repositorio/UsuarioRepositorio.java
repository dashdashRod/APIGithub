package Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
