package rs.ac.bg.fon.naprednajava.touristagency.mapper.authority;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.MyMapper;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.ReservationMapper;
import rs.ac.bg.fon.naprednajava.touristagency.requests.authority.CreateUserRequest;

/**
 * Mapper used for bi directional mapping between User Entity and Create User Request
 * @author mdjukanovic
 */
@Mapper(componentModel = "spring", uses = ReservationMapper.class, builder = @Builder(disableBuilder = true))
public interface UserCreateMapper extends MyMapper<UserEntity, CreateUserRequest> {
}
