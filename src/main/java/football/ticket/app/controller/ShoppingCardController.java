package football.ticket.app.controller;

import football.ticket.app.model.ShoppingCart;
import football.ticket.app.model.User;
import football.ticket.app.model.dto.response.ShoppingCardResponseDto;
import football.ticket.app.service.GameSessionService;
import football.ticket.app.service.ShoppingCartService;
import football.ticket.app.service.UserService;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import football.ticket.app.service.dto.mapping.impl.response.ShoppingCardResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-cards")
public class ShoppingCardController {
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<ShoppingCardResponseDto,
            ShoppingCart> shoppingCardDtoResponseMapper;
    private final GameSessionService gameSessionService;
    private final UserService userService;

    public ShoppingCardController(ShoppingCartService shoppingCartService,
                                  ShoppingCardResponseMapper shoppingCardDtoResponseMapper,
                                  GameSessionService gameSessionService,
                                  UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCardDtoResponseMapper = shoppingCardDtoResponseMapper;
        this.gameSessionService = gameSessionService;
        this.userService = userService;
    }

    @PostMapping("/game-sessions")
    public ShoppingCardResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        User user = userService.getById(userId);
        shoppingCartService.addSession(gameSessionService.get(movieSessionId), user);
        return shoppingCardDtoResponseMapper.toDto(shoppingCartService.getByUser(user));
    }

    @GetMapping("/by-user")
    public ShoppingCardResponseDto getShoppingCardByUserId(@RequestParam Long userId) {
        return shoppingCardDtoResponseMapper.toDto(shoppingCartService
                .getByUser(userService.getById(userId)));
    }
}
