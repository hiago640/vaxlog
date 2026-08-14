package br.com.hiago640.vaxlog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import br.com.hiago640.vaxlog.dto.VacinaRequestDTO;
import br.com.hiago640.vaxlog.dto.VacinaResponseDTO;
import br.com.hiago640.vaxlog.model.Vacina;

@Mapper(componentModel =  MappingConstants.ComponentModel.SPRING)
public interface VacinaMapper {

	@Mapping(target = "id", ignore = true)
	Vacina toEntity(VacinaRequestDTO dto);
	VacinaResponseDTO toResponse(Vacina vacina);
	
}
