package rs.ac.bg.fon.naprednajava.touristagency.mapper;

import org.mapstruct.Mapper;

import rs.ac.bg.fon.naprednajava.touristagency.dto.ReservationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.ReservationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.authority.UserCreateMapper;

@Mapper(componentModel = "spring", uses = UserCreateMapper.class)
public interface ReservationMapper {
	
	ReservationEntity toEntity(ReservationDto dto);
	ReservationDto toDto(ReservationEntity entity);

}
