package edu.unn.taxi.impl.controller;

import com.google.common.collect.Lists;
import edu.unn.taxi.impl.db.DriverRepository;
import edu.unn.taxi.impl.entity.Driver;
import edu.unn.taxi.impl.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/driver")
public class DriverController extends UserController {
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping(path = "/create")
    public @ResponseBody
    Driver createDriver(@RequestParam String name, @RequestParam String password, @RequestParam String description,
                        @RequestParam String carNumber) {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setPassword(password);
        driver.setDescription(description);
        driver.setCar(carNumber);
        driver.setStatus(Status.FREE);

        return driverRepository.save(driver);
    }

    @GetMapping(path = "/update")
    public @ResponseBody
    Driver updateDriver(@RequestParam int driverId, @RequestParam String description,
                        @RequestParam String carNumber, @RequestParam String status) {
        Driver driver = driverRepository.findById(driverId).orElse(null);

        if (driver == null) {
            return null;
        }

        driver.setDescription(description);
        driver.setCar(carNumber);
        driver.setStatus(Status.valueOf(status));

        return driverRepository.save(driver);
    }

    @GetMapping(path = "/get")
    public @ResponseBody
    Driver getDriver(@RequestParam int driverId) {
        return driverRepository.findById(driverId).orElse(null);
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody
    List<Driver> getAllDrivers() {
        return Lists.newArrayList(driverRepository.findAll());
    }

    @GetMapping(path = "/sync")
    public void syncLocations() {

    }
}
