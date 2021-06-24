package football.ticket.app.controller;

import football.ticket.app.model.Stadium;
import football.ticket.app.model.dto.request.StadiumRequestDto;
import football.ticket.app.model.dto.response.StadiumResponseDto;
import football.ticket.app.service.StadiumService;
import football.ticket.app.service.dto.mapping.DtoRequestMapper;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {
    private final StadiumService stadiumService;
    private final DtoRequestMapper<StadiumRequestDto, Stadium> stadiumDtoRequestMapper;
    private final DtoResponseMapper<StadiumResponseDto, Stadium> stadiumDtoResponseMapper;

    public StadiumController(StadiumService stadiumService,
                             DtoRequestMapper<StadiumRequestDto, Stadium>
                                     stadiumDtoRequestMapper,
                             DtoResponseMapper<StadiumResponseDto, Stadium>
                                     stadiumDtoResponseMapper) {
        this.stadiumService = stadiumService;
        this.stadiumDtoRequestMapper = stadiumDtoRequestMapper;
        this.stadiumDtoResponseMapper = stadiumDtoResponseMapper;
    }

    @PostMapping
    public StadiumResponseDto addStadium(@RequestBody @Valid StadiumRequestDto dto) {
        Stadium stadium = stadiumService.add(stadiumDtoRequestMapper.fromDto(dto));
        return stadiumDtoResponseMapper.toDto(stadium);
    }

    @GetMapping
    public List<StadiumResponseDto> getAllStadium() {
        return stadiumService.getAll().stream()
                .map(stadiumDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
