package br.com.hiago640.vaxlog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import br.com.hiago640.vaxlog.dto.UserRequestDTO;
import br.com.hiago640.vaxlog.dto.UserResponseDTO;
import br.com.hiago640.vaxlog.model.Usuario;

@Mapper(componentModel =  MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

	@Mapping(target = "id", ignore = true)
	Usuario toEntity(UserRequestDTO dto);
	UserResponseDTO toResponse(Usuario usuario);
	
}
