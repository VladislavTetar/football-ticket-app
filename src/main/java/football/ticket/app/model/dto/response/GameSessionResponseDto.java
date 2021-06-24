package football.ticket.app.model.dto.response;

import lombok.Data;

@Data
public class GameSessionResponseDto {
    private Long id;
    private String gameTitle;
    private String showTime;
    private int stadiumCapacity;
}
