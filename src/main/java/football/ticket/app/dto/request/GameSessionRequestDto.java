package football.ticket.app.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class GameSessionRequestDto {
    @Positive
    private Long gameId;
    @Positive
    private Long stadiumId;
    @NotNull
    private String showTime;

    public Long getMovieId() {
        return gameId;
    }

    public Long getCinemaHallId() {
        return stadiumId;
    }

    public String getShowTime() {
        return showTime;
    }
}
