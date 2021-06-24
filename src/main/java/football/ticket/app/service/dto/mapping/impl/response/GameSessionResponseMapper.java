package football.ticket.app.service.dto.mapping.impl.response;

import football.ticket.app.model.GameSession;
import football.ticket.app.model.dto.response.GameSessionResponseDto;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class GameSessionResponseMapper implements DtoResponseMapper<GameSessionResponseDto,
        GameSession> {
    @Override
    public GameSessionResponseDto toDto(GameSession gameSession) {
        GameSessionResponseDto gameSessionResponseDto = new GameSessionResponseDto();
        gameSessionResponseDto.setId(gameSession.getId());
        gameSessionResponseDto.setGameTitle(gameSession.getGame().getTitle());
        gameSessionResponseDto.setShowTime(gameSession.getShowTime()
                                            .format(DateTimeFormatter
                                                    .ofPattern("dd.MM.yyyy HH:mm")));
        gameSessionResponseDto.setStadiumCapacity(gameSession.getStadium().getCapacity());
        return gameSessionResponseDto;
    }
}
