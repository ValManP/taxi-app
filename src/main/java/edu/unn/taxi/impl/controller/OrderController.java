package edu.unn.taxi.impl.controller;

import edu.unn.taxi.impl.db.OrderRepository;
import edu.unn.taxi.impl.entity.*;
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

        return orderRepository.save(order);
    }

    @GetMapping(path="/get")
    public @ResponseBody Order getOrder(@RequestParam int orderId) {
        return orderRepository.findById(orderId).orElse(null);
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
        return orderRepository.findWithEmptyDriver();
    }

    @PostMapping(path = "/start")
    public void startOrder(@RequestParam int driverId, @RequestParam int orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        Driver driver = driverController.getDriver(driverId);

        if (order == null || driver == null) {
            return;
        }

        order.setDriver(driver);
        driver.setStatus(Status.BUSY);

        orderRepository.save(order);
}

    @PostMapping(path = "/complete")
    public void completeOrder(@RequestParam int orderId) {

    }
}
