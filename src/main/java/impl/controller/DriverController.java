package impl.controller;

import impl.entity.Car;
import impl.entity.Driver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/driver")
public class DriverController extends UserController {
    @GetMapping(path = "/create")
    public @ResponseBody
    Driver createDriver(@RequestParam String name, @RequestParam String password, @RequestParam String description, @RequestBody Car car) {
        return null;
    }

    @GetMapping(path = "/update")
    public @ResponseBody
    Driver updateDriver(@RequestParam int driverId, @RequestParam String description, @RequestBody Car car) {
        return null;
    }

    @GetMapping(path = "/get")
    public @ResponseBody
    Driver getDriver(@RequestParam int driverId) {
        return null;
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody
    List<Driver> getAllDrivers() {
        return null;
    }

    @PostMapping(path = "/sync")
    public void syncLocations() {

    }

    @PostMapping(path = "/start")
    public void startOrder(@RequestParam int driverId, @RequestParam int orderId) {

    }

    @PostMapping(path = "/complete")
    public void completeOrder(@RequestParam int orderId) {

    }
}
