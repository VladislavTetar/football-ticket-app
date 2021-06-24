package football.ticket.app.model.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GameSessionRequestDto {
    @NotNull
    private Long gameId;
    @NotNull
    private String showTime;
    @NotNull
    private Long stadiumId;
}
