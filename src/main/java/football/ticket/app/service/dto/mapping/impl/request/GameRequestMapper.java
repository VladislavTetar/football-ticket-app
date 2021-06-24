package football.ticket.app.service.dto.mapping.impl.request;

import football.ticket.app.model.Game;
import football.ticket.app.model.dto.request.GameRequestDto;
import football.ticket.app.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class GameRequestMapper implements DtoRequestMapper<GameRequestDto, Game> {
    @Override
    public Game fromDto(GameRequestDto dto) {
        Game game = new Game();
        game.setTitle(dto.getTitle());
        game.setDescription(dto.getDescription());
        return game;
    }
}
