package football.ticket.app.config;

import football.ticket.app.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register")
                .permitAll()
                .antMatchers(HttpMethod.GET,
                        "/stadiums",
                        "/games",
                        "/game-sessions/*")
                .hasAnyRole(Role.Roles.USER.name(), Role.Roles.ADMIN.name())
                .antMatchers(HttpMethod.POST,
                        "/stadiums",
                        "/games",
                        "/game-sessions")
                .hasRole(Role.Roles.ADMIN.name())
                .antMatchers(HttpMethod.PUT,
                        "/game-sessions/{id}")
                .hasRole(Role.Roles.ADMIN.name())
                .antMatchers(HttpMethod.DELETE,
                        "/game-sessions/{id}")
                .hasRole(Role.Roles.ADMIN.name())
                .antMatchers(HttpMethod.POST,
                        "/orders/complete",
                        "/shopping-cards/game-sessions")
                .hasRole(Role.Roles.USER.name())
                .antMatchers(HttpMethod.GET,
                        "/shopping-cards/by-user",
                        "/orders")
                .hasRole(Role.Roles.USER.name())
                .antMatchers(HttpMethod.GET,
                        "/users/by-email")
                .hasRole(Role.Roles.ADMIN.name())
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
