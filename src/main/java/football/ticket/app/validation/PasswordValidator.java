package football.ticket.app.validation;

import football.ticket.app.model.dto.request.RegisterRequestDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements
        ConstraintValidator<Password, Object> {
    @Override
    public boolean isValid(Object user,
                           ConstraintValidatorContext constraintValidatorContext) {
        RegisterRequestDto requestDto = (RegisterRequestDto) user;
        return requestDto.getPassword().equals(requestDto.getRepeatPassword());
    }
}
