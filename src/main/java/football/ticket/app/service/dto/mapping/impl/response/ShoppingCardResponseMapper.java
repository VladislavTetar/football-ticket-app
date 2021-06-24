package football.ticket.app.service.dto.mapping.impl.response;

import football.ticket.app.model.ShoppingCart;
import football.ticket.app.model.Ticket;
import football.ticket.app.model.dto.response.ShoppingCardResponseDto;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCardResponseMapper implements
        DtoResponseMapper<ShoppingCardResponseDto, ShoppingCart> {
    @Override
    public ShoppingCardResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCardResponseDto responseDto = new ShoppingCardResponseDto();
        responseDto.setId(shoppingCart.getId());
        responseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        responseDto.setUserId(shoppingCart.getUser().getId());
        return responseDto;
    }
}
