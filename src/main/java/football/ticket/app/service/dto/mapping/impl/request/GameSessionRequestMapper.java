package football.ticket.app.service.dto.mapping.impl.request;

import football.ticket.app.model.Game;
import football.ticket.app.model.GameSession;
import football.ticket.app.model.Stadium;
import football.ticket.app.model.dto.request.GameSessionRequestDto;
import football.ticket.app.service.GameService;
import football.ticket.app.service.StadiumService;
import football.ticket.app.service.dto.mapping.DtoRequestMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class GameSessionRequestMapper implements DtoRequestMapper<GameSessionRequestDto,
        GameSession> {
    public static final String PATTERN = "dd.MM.yyyy HH:mm";
    private final StadiumService stadiumService;
    private final GameService gameService;

    public GameSessionRequestMapper(StadiumService stadiumService,
                                    GameService gameService) {
        this.stadiumService = stadiumService;
        this.gameService = gameService;
    }

    @Override
    public GameSession fromDto(GameSessionRequestDto dto) {
        GameSession gameSession = new GameSession();
        Game game = gameService.get(dto.getGameId());
        Stadium stadium = stadiumService.get(dto.getStadiumId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        gameSession.setGame(game);
        gameSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        gameSession.setStadium(stadium);
        return gameSession;
    }
}
