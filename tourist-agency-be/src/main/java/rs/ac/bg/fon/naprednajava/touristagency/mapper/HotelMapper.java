package rs.ac.bg.fon.naprednajava.touristagency.mapper;

import org.mapstruct.Mapper;

import rs.ac.bg.fon.naprednajava.touristagency.dto.HotelDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.HotelEntity;

@Mapper(componentModel = "spring", uses = RoomMapper.class)
public interface HotelMapper extends MyMapper<HotelEntity, HotelDto>{

}
