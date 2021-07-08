package rs.ac.bg.fon.naprednajava.touristagency.controller.authority;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.naprednajava.touristagency.dto.ReservationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.authority.UserViewMapper;
import rs.ac.bg.fon.naprednajava.touristagency.requests.authority.AuthUserRequest;
import rs.ac.bg.fon.naprednajava.touristagency.requests.authority.CreateUserRequest;
import rs.ac.bg.fon.naprednajava.touristagency.security.JwtTokenUtil;
import rs.ac.bg.fon.naprednajava.touristagency.service.UserService;

import java.util.Set;

import javax.validation.Valid;

@RestController @RequestMapping("auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserViewMapper userViewMapper;

    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenUtil jwtTokenUtil, UserViewMapper userViewMapper, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userViewMapper = userViewMapper;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid AuthUserRequest authUserRequest) {
        try {
            Authentication authentication = this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authUserRequest.getUsername(), authUserRequest.getPassword()));
            UserEntity userEntity = (UserEntity) authentication.getPrincipal();
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, this.jwtTokenUtil.generateAccessToken(userEntity))
                    .body(this.userViewMapper.toDto(userEntity));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("register")
    public UserDto register(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return this.userService.createUser(createUserRequest);
    }
    //nije obradjen error ako ne postoji id
    @GetMapping(path="reservations/{id}")
    public ResponseEntity<Set<ReservationDto>> getReservationsByUserId(@PathVariable Long id){
    	return ResponseEntity.status(HttpStatus.OK).body(userService.getReservationsByUserId(id));
    }
    
    @PostMapping("reservation/{idRes}/user/{idUser}")
    public ResponseEntity<Set<ReservationDto>> addUserToReservation(@PathVariable Long idRes, @PathVariable Long idUser){
    	userService.addUserToReservation(idUser, idRes);
    	return getReservationsByUserId(idUser);
    }
    
    @DeleteMapping("reservation/{idRes}/user/{idUser}")
    public ResponseEntity<Set<ReservationDto>> removeUserFromReservation(@PathVariable Long idRes, @PathVariable Long idUser){
    	userService.removeUserFromReservation(idUser, idRes);
    	return getReservationsByUserId(idUser);
    }
}