package football.ticket.app.service.dto.mapping.impl.response;

import football.ticket.app.model.User;
import football.ticket.app.model.dto.response.UserResponseDto;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements DtoResponseMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setEmail(user.getEmail());
        responseDto.setId(user.getId());
        return responseDto;
    }
}
