package impl.controller;

import impl.db.OrderRepository;
import impl.entity.Location;
import impl.entity.Order;
import impl.entity.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DriverController driverController;
    @Autowired
    private ClientController clientController;

    @GetMapping(path="/create")
    public @ResponseBody Order createOrder(@RequestParam int driverId, @RequestParam int clientId, @RequestBody Location start,
                                           @RequestBody Location finish, @RequestParam double price, @RequestBody PaymentType paymentType) {
        Order order = new Order();
        order.setClient(clientController.getClient(clientId));
        order.setDriver(driverController.getDriver(driverId));
        order.setStart(start);
        order.setFinish(finish);
        order.setPrice(price);
        order.setPaymentType(paymentType);

        orderRepository.save(order);
        return order;
    }

    @GetMapping(path="/get")
    public @ResponseBody Order getOrder(@RequestParam int orderId) {
        return orderRepository.findById(orderId).get();
    }

    @GetMapping(path="/getByClient")
    public @ResponseBody List<Order> getOrdersByClient(@RequestParam int clientId) {
        return null;
    }

    @GetMapping(path="/getByDriver")
    public @ResponseBody List<Order> getOrdersByDriver(@RequestParam int driverId) {
        return null;
    }

    @GetMapping(path="/getFree")
    public @ResponseBody List<Order> getFreeOrders() {
        return null;
    }
}
