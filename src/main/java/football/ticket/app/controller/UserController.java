package football.ticket.app.controller;

import football.ticket.app.model.User;
import football.ticket.app.model.dto.response.UserResponseDto;
import football.ticket.app.service.UserService;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import football.ticket.app.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;

    public UserController(UserService userService,
                          UserResponseMapper userDtoResponseMapper) {
        this.userService = userService;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto findUserByEmail(@RequestParam String email) {
        return userDtoResponseMapper.toDto(userService.findByEmail(email));
    }
}
