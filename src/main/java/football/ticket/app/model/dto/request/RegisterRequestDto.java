package football.ticket.app.model.dto.request;

import football.ticket.app.validation.Email;
import football.ticket.app.validation.Password;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Password
public class RegisterRequestDto {
    private static final int MIN_PASSWORD_LENGTH = 6;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = MIN_PASSWORD_LENGTH)
    private String password;
    @NotNull
    @Size(min = MIN_PASSWORD_LENGTH)
    private String repeatPassword;
}
