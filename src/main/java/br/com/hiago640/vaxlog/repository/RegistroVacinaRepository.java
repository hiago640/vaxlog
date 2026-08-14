package br.com.hiago640.vaxlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hiago640.vaxlog.model.RegistroVacina;
import br.com.hiago640.vaxlog.model.Usuario;

public interface RegistroVacinaRepository extends JpaRepository<RegistroVacina, Long> {

	public List<RegistroVacina> findByUsuario(Usuario usuario);
	
}
