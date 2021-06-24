package football.ticket.app.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StadiumRequestDto {
    private static final int MIN_STADIUM_CAPACITY = 8000;
    @NotNull
    @Min(value = MIN_STADIUM_CAPACITY)
    private int capacity;
    @NotNull
    private String description;
}
