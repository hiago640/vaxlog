package br.com.hiago640.vaxlog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import br.com.hiago640.vaxlog.dto.RegistroVacinaRequestDTO;
import br.com.hiago640.vaxlog.dto.RegistroVacinaResponseDTO;
import br.com.hiago640.vaxlog.model.RegistroVacina;
import br.com.hiago640.vaxlog.model.Usuario;
import br.com.hiago640.vaxlog.model.Vacina;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { UsuarioMapper.class, VacinaMapper.class })
public interface RegistroVacinaMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "dose", source = "dto.dose")
	RegistroVacina toEntity(RegistroVacinaRequestDTO dto, Usuario usuario, Vacina vacina);

	RegistroVacinaResponseDTO toResponse(RegistroVacina registroVacina);

}
