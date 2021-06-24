package rs.ac.bg.fon.naprednajava.touristagency.controller.authority;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.authority.UserViewMapper;
import rs.ac.bg.fon.naprednajava.touristagency.requests.authority.AuthUserRequest;
import rs.ac.bg.fon.naprednajava.touristagency.requests.authority.CreateUserRequest;
import rs.ac.bg.fon.naprednajava.touristagency.security.JwtTokenUtil;
import rs.ac.bg.fon.naprednajava.touristagency.service.UserService;

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

}
