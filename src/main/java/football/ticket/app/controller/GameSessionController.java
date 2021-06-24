package football.ticket.app.controller;

import football.ticket.app.model.GameSession;
import football.ticket.app.model.dto.request.GameSessionRequestDto;
import football.ticket.app.model.dto.response.GameSessionResponseDto;
import football.ticket.app.service.GameSessionService;
import football.ticket.app.service.dto.mapping.DtoRequestMapper;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game-sessions")
public class GameSessionController {
    private final GameSessionService gameSessionService;
    private final DtoRequestMapper<GameSessionRequestDto, GameSession>
            gameSessionDtoRequestMapper;
    private final DtoResponseMapper<GameSessionResponseDto, GameSession>
            gameSessionDtoResponseMapper;

    public GameSessionController(GameSessionService gameSessionService,
                                 DtoRequestMapper<GameSessionRequestDto, GameSession>
                                          dtoRequestMapper,
                                 DtoResponseMapper<GameSessionResponseDto, GameSession>
                                          dtoResponseMapper) {
        this.gameSessionService = gameSessionService;
        this.gameSessionDtoRequestMapper = dtoRequestMapper;
        this.gameSessionDtoResponseMapper = dtoResponseMapper;
    }

    @PostMapping
    public GameSessionResponseDto addGameSession(@RequestBody @Valid GameSessionRequestDto dto) {
        GameSession gameSession
                = gameSessionService.add(gameSessionDtoRequestMapper.fromDto(dto));
        return gameSessionDtoResponseMapper.toDto(gameSession);
    }

    @GetMapping("/available")
    public List<GameSessionResponseDto> getAllAvailableSessions(@RequestParam Long id,
                                                                @RequestParam
                                                          @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                            LocalDate date) {
        return gameSessionService.findAvailableSessions(id, date).stream()
                .map(gameSessionDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody GameSessionRequestDto gameSessionRequestDto) {
        GameSession gameSession = gameSessionDtoRequestMapper.fromDto(gameSessionRequestDto);
        gameSession.setId(id);
        gameSessionService.update(gameSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gameSessionService.remove(id);
    }
}
