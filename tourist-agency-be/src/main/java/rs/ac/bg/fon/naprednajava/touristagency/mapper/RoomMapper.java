package rs.ac.bg.fon.naprednajava.touristagency.mapper;

import org.mapstruct.Mapper;

import rs.ac.bg.fon.naprednajava.touristagency.dto.RoomDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomEntity;

@Mapper(componentModel = "spring", uses = HotelMapper.class)
public interface RoomMapper extends MyMapper<RoomEntity, RoomDto>{

}
