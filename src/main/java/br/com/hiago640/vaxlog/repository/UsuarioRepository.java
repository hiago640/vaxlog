package br.com.hiago640.vaxlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hiago640.vaxlog.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
