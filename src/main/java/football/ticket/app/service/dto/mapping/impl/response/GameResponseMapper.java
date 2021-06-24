package football.ticket.app.service.dto.mapping.impl.response;

import football.ticket.app.model.Game;
import football.ticket.app.model.dto.response.GameResponseDto;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class GameResponseMapper implements DtoResponseMapper<GameResponseDto, Game> {
    @Override
    public GameResponseDto toDto(Game game) {
        GameResponseDto gameResponseDto = new GameResponseDto();
        gameResponseDto.setId(game.getId());
        gameResponseDto.setTitle(game.getTitle());
        gameResponseDto.setDescription(game.getDescription());
        return gameResponseDto;
    }
}
