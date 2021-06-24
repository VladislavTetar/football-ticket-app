package football.ticket.app.service.dto.mapping.impl.response;

import football.ticket.app.model.Stadium;
import football.ticket.app.model.dto.response.StadiumResponseDto;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class StadiumResponseMapper implements DtoResponseMapper<StadiumResponseDto,
        Stadium> {
    @Override
    public StadiumResponseDto toDto(Stadium stadium) {
        StadiumResponseDto stadiumResponseDto = new StadiumResponseDto();
        stadiumResponseDto.setId(stadium.getId());
        stadiumResponseDto.setCapacity(stadium.getCapacity());
        stadiumResponseDto.setDescription(stadium.getDescription());
        return stadiumResponseDto;
    }
}
