package rs.ac.bg.fon.naprednajava.touristagency.mapper;

import org.mapstruct.Mapper;


import rs.ac.bg.fon.naprednajava.touristagency.dto.DestinationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.DestinationEntity;

@Mapper(componentModel = "spring", uses = StateMapper.class)
public interface DestinationMapper extends MyMapper<DestinationEntity, DestinationDto>{

	
	
}
