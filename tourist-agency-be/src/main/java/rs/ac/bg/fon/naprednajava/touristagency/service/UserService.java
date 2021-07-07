package rs.ac.bg.fon.naprednajava.touristagency.service;

import java.util.Set;

import rs.ac.bg.fon.naprednajava.touristagency.dto.ReservationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.requests.authority.CreateUserRequest;

/**
 * User service
 *
 * @author mdjukanovic
 */
public interface UserService {

    /**
     * Creates user from createUserRequest
     * @param createUserRequest userRequest to save
     * @return User object
     */
    UserDto createUser(CreateUserRequest createUserRequest);

    /**
     * Updates userEntity object
     * @param userEntity userEntity to update
     * @return User entity
     */
    UserEntity save(UserEntity userEntity);

    /**
     * Finds user  by id
     * @param id id of the user for search
     * @return User entity
     */
    UserEntity findById(Long id);
    
    Set<ReservationDto> getReservationsByUserId(Long userId);
}
