package br.com.hiago640.vaxlog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hiago640.vaxlog.model.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, UUID> {

}
