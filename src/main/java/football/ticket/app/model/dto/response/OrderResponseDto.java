package football.ticket.app.model.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private String orderDate;
    private Long userId;
}
