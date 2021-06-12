package rs.ac.bg.fon.naprednajava.touristagency.mapper;

import org.mapstruct.Mapper;

import rs.ac.bg.fon.naprednajava.touristagency.dto.ReservationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.ReservationEntity;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
	
	ReservationEntity toEntity(ReservationDto dto);
	ReservationDto toDto(ReservationEntity entity);

}
