package football.ticket.app.controller;

import football.ticket.app.model.Order;
import football.ticket.app.model.dto.response.OrderResponseDto;
import football.ticket.app.service.OrderService;
import football.ticket.app.service.ShoppingCartService;
import football.ticket.app.service.UserService;
import football.ticket.app.service.dto.mapping.DtoResponseMapper;
import football.ticket.app.service.dto.mapping.impl.response.OrderResponseMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;

    public OrderController(OrderService orderService,
                           UserService userService,
                           ShoppingCartService shoppingCartService,
                           OrderResponseMapper orderDtoResponseMapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long userId) {
        return orderDtoResponseMapper.toDto(orderService.completeOrder(
                shoppingCartService.getByUser(userService.getById(userId))));
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.getById(userId))
                 .stream()
                 .map(orderDtoResponseMapper::toDto)
                 .collect(Collectors.toList());
    }
}
