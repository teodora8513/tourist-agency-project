package rs.ac.bg.fon.naprednajava.touristagency.mapper;

import rs.ac.bg.fon.naprednajava.touristagency.dto.MyDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.MyEntity;

public interface MyMapper<Entity extends MyEntity, Dto extends MyDto> {

	public Entity toEntity(Dto dto);
	public Dto toDto(Entity entity);
}
