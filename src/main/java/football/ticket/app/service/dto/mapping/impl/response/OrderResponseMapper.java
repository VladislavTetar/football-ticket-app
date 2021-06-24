package football.ticket.app.service.dto.mapping.impl.response;

import football.ticket.app.model.Order;
import football.ticket.app.model.Ticket;
import football.ticket.app.model.dto.response.OrderResponseDto;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setOrderDate(order.getOrderDate().toString());
        responseDto.setUserId(order.getUser().getId());
        responseDto.setTicketIds(order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        responseDto.setId(order.getId());
        return responseDto;
    }
}
