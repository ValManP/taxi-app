package edu.unn.taxi.impl.controller;

import edu.unn.taxi.impl.db.OrderRepository;
import edu.unn.taxi.impl.entity.Driver;
import edu.unn.taxi.impl.entity.Order;
import edu.unn.taxi.impl.entity.PaymentType;
import edu.unn.taxi.impl.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DriverController driverController;
    @Autowired
    private ClientController clientController;

    @GetMapping(path = "/create")
    public @ResponseBody
    Order createOrder(@RequestParam int driverId, @RequestParam int clientId, @RequestParam String start,
                      @RequestParam String finish, @RequestParam double price, @RequestParam String paymentType) {
        Order order = new Order();
        order.setClient(clientController.getClient(clientId));
        order.setDriver(driverController.getDriver(driverId));
        order.setStart(start);
        order.setFinish(finish);
        order.setPrice(price);
        order.setTimestamp(new Date());
        order.setPaymentType(PaymentType.valueOf(paymentType));

        return orderRepository.save(order);
    }

    @GetMapping(path = "/get")
    public @ResponseBody
    Order getOrder(@RequestParam int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @GetMapping(path = "/getByClient")
    public @ResponseBody
    List<Order> getOrdersByClient(@RequestParam int clientId) {
        return orderRepository.findByClient(clientController.getClient(clientId));
    }

    @GetMapping(path = "/getByDriver")
    public @ResponseBody
    List<Order> getOrdersByDriver(@RequestParam int driverId) {
        return orderRepository.findByDriver(driverController.getDriver(driverId));
    }

    @GetMapping(path = "/getFree")
    public @ResponseBody
    List<Order> getFreeOrders() {
        return orderRepository.findWithEmptyDriver();
    }

    @GetMapping(path = "/start")
    public @ResponseBody
    Order startOrder(@RequestParam int driverId, @RequestParam int orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        Driver driver = driverController.getDriver(driverId);

        if (order == null || driver == null) {
            return null;
        }

        order.setDriver(driver);
        driver.setStatus(Status.BUSY);

        return orderRepository.save(order);
    }
}
