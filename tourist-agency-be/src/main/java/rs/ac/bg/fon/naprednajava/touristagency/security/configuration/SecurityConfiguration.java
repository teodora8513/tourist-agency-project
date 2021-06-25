package rs.ac.bg.fon.naprednajava.touristagency.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import rs.ac.bg.fon.naprednajava.touristagency.repository.authority.UserRepository;
import rs.ac.bg.fon.naprednajava.touristagency.security.filter.JwtTokenFilter;

import static java.lang.String.format;

/**
 * Security configuration for the application
 *
 * @author mdjukanovic
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /** User Repository **/
    private final UserRepository userRepository;

    /** JWT token filter **/
    private final JwtTokenFilter jwtTokenFilter;

    public SecurityConfiguration(UserRepository userRepository, JwtTokenFilter jwtTokenFilter) {
        this.userRepository = userRepository;
        this.jwtTokenFilter = jwtTokenFilter;
    }

    /**
     * Checking if the user with username exists
     * @param auth Authentication manager builder
     * @throws Exception username not found
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> this.userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException(format("User %s not found", username))));
    }

    /**
     * Configuring web security
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disabled CORS and disable CSRF
        http = http.cors().disable();
        http = http.csrf().disable();

        // Set session manager to stateless
        http = http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http.exceptionHandling().
                authenticationEntryPoint((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.sendError(
                            httpServletResponse.SC_UNAUTHORIZED,
                            e.getMessage()
                    );
                }).and();
        // Set permissions on endpoints

         http.authorizeRequests().antMatchers("/").permitAll();
//        http.authorizeRequests().antMatchers("api/public/**").permitAll()
//                .anyRequest().authenticated();

        // Add jwt token filter
        http.addFilterBefore(
                this.jwtTokenFilter,
                UsernamePasswordAuthenticationFilter.class
        );
    }

    /**
     * Configuring password encode schema
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
