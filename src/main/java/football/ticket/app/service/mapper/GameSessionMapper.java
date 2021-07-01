package football.ticket.app.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import football.ticket.app.dto.request.GameSessionRequestDto;
import football.ticket.app.dto.response.GameSessionResponseDto;
import football.ticket.app.model.GameSession;
import football.ticket.app.service.GameService;
import football.ticket.app.service.StadiumService;
import football.ticket.app.util.DateTimePatternUtil;
import org.springframework.stereotype.Component;

@Component
public class GameSessionMapper implements RequestDtoMapper<GameSessionRequestDto, GameSession>,
        ResponseDtoMapper<GameSessionResponseDto, GameSession> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final StadiumService stadiumService;
    private final GameService gameService;

    public GameSessionMapper(StadiumService stadiumService, GameService gameService) {
        this.stadiumService = stadiumService;
        this.gameService = gameService;
    }

    @Override
    public GameSession mapToModel(GameSessionRequestDto dto) {
        GameSession gameSession = new GameSession();
        gameSession.setMovie(gameService.get(dto.getMovieId()));
        gameSession.setCinemaHall(stadiumService.get(dto.getCinemaHallId()));
        gameSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return gameSession;
    }

    @Override
    public GameSessionResponseDto mapToDto(GameSession gameSession) {
        GameSessionResponseDto responseDto = new GameSessionResponseDto();
        responseDto.setMovieSessionId(gameSession.getId());
        responseDto.setCinemaHallId(gameSession.getCinemaHall().getId());
        responseDto.setMovieId(gameSession.getMovie().getId());
        responseDto.setMovieTitle(gameSession.getMovie().getTitle());
        responseDto.setShowTime(gameSession.getShowTime().format(formatter));
        return responseDto;
    }
}
