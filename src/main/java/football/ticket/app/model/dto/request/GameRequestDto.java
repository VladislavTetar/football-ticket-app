package football.ticket.app.model.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GameRequestDto {
    private static final int DEFAULT_SIZE = 1;
    @NotNull
    private String title;
    @NotNull
    private String description;
}
