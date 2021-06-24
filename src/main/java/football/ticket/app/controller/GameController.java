package football.ticket.app.controller;

import football.ticket.app.model.Game;
import football.ticket.app.model.dto.request.GameRequestDto;
import football.ticket.app.model.dto.response.GameResponseDto;
import football.ticket.app.service.GameService;
import football.ticket.app.service.dto.mapping.DtoRequestMapper;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    private final DtoRequestMapper<GameRequestDto, Game> gameDtoRequestMapper;
    private final DtoResponseMapper<GameResponseDto, Game> gameDtoResponseMapper;

    public GameController(GameService gameService,
                          DtoRequestMapper<GameRequestDto, Game> gameDtoRequestMapper,
                          DtoResponseMapper<GameResponseDto, Game> gameDtoResponseMapper) {
        this.gameService = gameService;
        this.gameDtoRequestMapper = gameDtoRequestMapper;
        this.gameDtoResponseMapper = gameDtoResponseMapper;
    }

    @PostMapping
    public GameResponseDto addGame(@RequestBody @Valid GameRequestDto dto) {
        Game game = gameService.add(gameDtoRequestMapper.fromDto(dto));
        return gameDtoResponseMapper.toDto(game);
    }

    @GetMapping
    public List<GameResponseDto> getAllGames() {
        return gameService.getAll().stream()
                .map(gameDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
