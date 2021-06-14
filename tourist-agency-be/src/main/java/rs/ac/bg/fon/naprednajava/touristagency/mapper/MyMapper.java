package rs.ac.bg.fon.naprednajava.touristagency.mapper;

import rs.ac.bg.fon.naprednajava.touristagency.dto.MyDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.MyEntity;

import java.util.List;

public interface MyMapper<Entity extends MyEntity, Dto extends MyDto> {

	public Entity toEntity(Dto dto);
	public Dto toDto(Entity entity);

	/**
	 * Maps list of DTOs to list of Entites
	 * @param dtoList DTO list
	 * @return list of entities
	 */
	List<Entity> toEntity(List<Dto> dtoList);

	/**
	 * Maps list of Entities to list of DTOs
	 * @param entityList entity list
	 * @return list of DTOs
	 */
	List<Dto> toDto(List<Entity> entityList);
}
