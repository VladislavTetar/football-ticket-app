package football.ticket.app.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GameRequestDto {
    @NotNull
    private String gameTitle;
    @Size(max = 200)
    private String gameDescription;

    public String getMovieTitle() {
        return gameTitle;
    }

    public String getMovieDescription() {
        return gameDescription;
    }
}
