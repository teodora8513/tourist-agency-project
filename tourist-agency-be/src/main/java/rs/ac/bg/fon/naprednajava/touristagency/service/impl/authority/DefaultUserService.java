package rs.ac.bg.fon.naprednajava.touristagency.service.impl.authority;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.naprednajava.touristagency.dto.ReservationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.ReservationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.ReservationMapper;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.authority.UserCreateMapper;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.authority.UserViewMapper;
import rs.ac.bg.fon.naprednajava.touristagency.repository.ReservationRepository;
import rs.ac.bg.fon.naprednajava.touristagency.repository.authority.UserRepository;
import rs.ac.bg.fon.naprednajava.touristagency.requests.authority.CreateUserRequest;
import rs.ac.bg.fon.naprednajava.touristagency.service.RoleService;
import rs.ac.bg.fon.naprednajava.touristagency.service.UserService;
import rs.ac.bg.fon.naprednajava.touristagency.service.impl.ReservationService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.ValidationException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of the User Service
 *
 * @author mdjukanovic
 */
@Service
@Transactional
public class DefaultUserService implements UserService {

    /** User Repository **/
    private final UserRepository userRepository;

    /** Password encoder **/
    private final PasswordEncoder passwordEncoder;

    /** User View Mapper **/
    private final UserViewMapper userViewMapper;

    /** User Create Mapper **/
    private final UserCreateMapper userCreateMapper;

    private final ReservationMapper reservationMapper;
    
    /** Role Service **/
    private final RoleService roleService;
    
    private final ReservationService reservationService;

    private final ReservationRepository reservationRepository;
    
    public DefaultUserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                              UserViewMapper userViewMapper, UserCreateMapper userCreateMapper,
                              RoleService roleService, ReservationMapper reservationMapper,
                              ReservationService resService,
                              ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userViewMapper = userViewMapper;
        this.userCreateMapper = userCreateMapper;
        this.roleService = roleService;
        this.reservationMapper = reservationMapper;
        this.reservationService = resService;
        this.reservationRepository = reservationRepository;
    }

    /**
     * Creates user
     * @param createUserRequest userRequest to save
     * @return User DTO
     */
    @Override
    public UserDto createUser(CreateUserRequest createUserRequest) {
        Objects.requireNonNull(createUserRequest);

        if(this.userRepository.findByUsername(createUserRequest.getUsername()).isPresent()) {
            throw new ValidationException("Username exists!");
        }

        if(!StringUtils.equals(createUserRequest.getPassword(), createUserRequest.getRePassword())) {
            throw new ValidationException("Passwords don't match");
        }

        UserEntity userEntity = this.userCreateMapper.toEntity(createUserRequest);
        userEntity.setPassword(this.passwordEncoder.encode(userEntity.getPassword()));

        userEntity = this.userRepository.save(userEntity);

        userEntity = this.roleService.addUserToRole(userEntity.getId(), RoleService.ROLE_USER);

        return this.userViewMapper.toDto(userEntity);
    }

    /**
     * Update User
     * @param userEntity userEntity to update
     * @return User Entity
     */
    @Override
    public UserEntity save(UserEntity userEntity) {
        Objects.requireNonNull(userEntity);
        Objects.requireNonNull(userEntity.getId());

        this.userRepository.findById(userEntity.getId()).orElseThrow(() ->
                new EntityNotFoundException("User with that id does not exists!")
        );
        return this.userRepository.save(userEntity);
    }

    /**
     * Search users by id
     * @param id id of the user for search
     * @return User Entity
     */
    @Override
    public UserEntity findById(Long id) {
        Objects.requireNonNull(id);

        return this.userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User with that id does not exists"));
    }

    	@Override
    	public Set<ReservationDto> getReservationsByUserId(Long userId) {
    	UserEntity user = findById(userId);
    	Set<ReservationEntity> reservations = user.getReservations();
    	return reservations.stream().map(reservationMapper::toDto).collect(Collectors.toSet());
        
    }
    	@Override
    	public String removeUserFromReservation(Long idUser, Long idRes) {
    		Optional<UserEntity> user = userRepository.findById(idUser);
    		
    		
    		if(user.isPresent()) {
    			Optional<ReservationEntity> res = reservationRepository.findById(idRes);
    			if(res.isPresent()) {
    			Set<ReservationEntity> reservations = user.get().getReservations();
    			reservations.remove(res.get());
    			
    			user.get().setReservations(reservations);
    			res.get().setNumberOfArrangementsLeft(res.get().getNumberOfArrangementsLeft()+1);
    			userRepository.save(user.get());
    			
    			
    			for (ReservationEntity reservationEntity : user.get().getReservations()) {
    				System.out.println(reservationEntity.getId());
				}
    			
    			
    			
    			return "User " + idUser + " removed from reservation " + idRes;
			}
			else
				throw new EntityNotFoundException("Reservation with id " + idRes + " was not found!");
		}
		else
		 throw new EntityNotFoundException("User with id " + idUser + " was not found!");
    		
    	}
    	
    	@Override
    	public String addUserToReservation(Long idUser, Long idRes) {
    		Optional<UserEntity> user = userRepository.findById(idUser);
    		
    		
    		if(user.isPresent()){
    			Optional<ReservationEntity> res = reservationRepository.findById(idRes);
    			if(res.isPresent()) {
    			Set<ReservationEntity> reservations = user.get().getReservations();
    			//TODO Provera da li user vec ima tu rezervaciju
    			reservations.remove(res.get());
    			res.get().setNumberOfArrangementsLeft(res.get().getNumberOfArrangementsLeft()+1);
    			return "User " + idUser + " added to reservation " + idRes;
    			}
    			else
    				throw new EntityNotFoundException("Reservation with id " + idRes + " was not found!");
    		}
    		else
    		 throw new EntityNotFoundException("User with id " + idUser + " was not found!");
    		
    	}
}
