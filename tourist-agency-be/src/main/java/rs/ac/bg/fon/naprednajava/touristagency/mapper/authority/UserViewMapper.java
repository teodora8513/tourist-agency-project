package rs.ac.bg.fon.naprednajava.touristagency.mapper.authority;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.MyMapper;

/**
 * Mapper used for bi directional mapping between User Entity and User Dto
 * @author mdjukanovic
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UserViewMapper extends MyMapper<UserEntity, UserDto> {
}
