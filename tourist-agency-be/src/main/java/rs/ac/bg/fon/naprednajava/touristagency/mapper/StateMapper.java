package rs.ac.bg.fon.naprednajava.touristagency.mapper;

import org.mapstruct.Mapper;


import rs.ac.bg.fon.naprednajava.touristagency.dto.StateDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.StateEntity;

@Mapper(componentModel="spring")
public interface StateMapper {
	
	StateEntity toEntity(StateDto dto);
	StateDto toDto(StateEntity entity);
}
