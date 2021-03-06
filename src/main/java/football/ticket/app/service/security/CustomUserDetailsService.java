package football.ticket.app.service.security;

import football.ticket.app.exception.DataProcessingException;
import football.ticket.app.model.User;
import football.ticket.app.service.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User userByEmail;
        try {
            userByEmail = userService.findByEmail(userEmail);
        } catch (DataProcessingException e) {
            throw new UsernameNotFoundException("Can't find user by email " + userEmail, e);
        }
        UserBuilder builder = org.springframework.security.core.userdetails
                .User.withUsername(userEmail);
        builder.password(userByEmail.getPassword());
        builder.roles(userByEmail.getRoles()
                            .stream()
                            .map(r -> r.getRole().name())
                            .toArray(String[]::new));
        return builder.build();
    }
}
