package rs.ac.bg.fon.naprednajava.touristagency.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import rs.ac.bg.fon.naprednajava.touristagency.dto.TransportationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.TransportationEntity;

@Mapper(componentModel = "spring", uses = DestinationMapper.class)
public interface TransportationMapper {

	TransportationDto toDto(TransportationEntity entity);

	TransportationEntity toEntity(TransportationDto dto);
}
