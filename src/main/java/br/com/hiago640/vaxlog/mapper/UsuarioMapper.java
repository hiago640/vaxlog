package br.com.hiago640.vaxlog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.hiago640.vaxlog.dto.CreateUserDTO;
import br.com.hiago640.vaxlog.dto.UserResponseDTO;
import br.com.hiago640.vaxlog.model.Usuario;

@Mapper(componentModel =  MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

	Usuario toEntity(CreateUserDTO dto);
	UserResponseDTO toResponse(Usuario usuario);
	
}
