package football.ticket.app.service.mapper;

import football.ticket.app.dto.request.GameRequestDto;
import football.ticket.app.dto.response.GameResponseDto;
import football.ticket.app.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper implements RequestDtoMapper<GameRequestDto, Game>,
        ResponseDtoMapper<GameResponseDto, Game> {
    @Override
    public Game mapToModel(GameRequestDto dto) {
        Game game = new Game();
        game.setTitle(dto.getMovieTitle());
        game.setDescription(dto.getMovieDescription());
        return game;
    }

    @Override
    public GameResponseDto mapToDto(Game game) {
        GameResponseDto responseDto = new GameResponseDto();
        responseDto.setMovieId(game.getId());
        responseDto.setMovieTitle(game.getTitle());
        responseDto.setMovieDescription(game.getDescription());
        return responseDto;
    }
}
