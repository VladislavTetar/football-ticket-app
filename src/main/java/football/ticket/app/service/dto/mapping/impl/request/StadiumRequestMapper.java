package football.ticket.app.service.dto.mapping.impl.request;

import football.ticket.app.model.Stadium;
import football.ticket.app.model.dto.request.StadiumRequestDto;
import football.ticket.app.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class StadiumRequestMapper implements DtoRequestMapper<StadiumRequestDto, Stadium> {
    @Override
    public Stadium fromDto(StadiumRequestDto dto) {
        Stadium stadium = new Stadium();
        stadium.setCapacity(dto.getCapacity());
        stadium.setDescription(dto.getDescription());
        return stadium;
    }
}
