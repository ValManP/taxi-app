package impl.controller;

import com.google.common.collect.Lists;
import impl.db.DriverRepository;
import impl.entity.Car;
import impl.entity.Driver;
import impl.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/driver")
public class DriverController extends UserController {
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping(path = "/create")
    public @ResponseBody
    Driver createDriver(@RequestParam String name, @RequestParam String password, @RequestParam String description, @RequestBody Car car) {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setPassword(password);
        driver.setDescription(description);
        driver.setCar(car);
        driver.setStatus(Status.FREE);

        return driverRepository.save(driver);
    }

    @GetMapping(path = "/update")
    public @ResponseBody
    Driver updateDriver(@RequestParam int driverId, @RequestParam String description, @RequestBody Car car) {
        Driver driver = driverRepository.findById(driverId).orElse(null);

        if (driver == null) {
            return null;
        }

        driver.setDescription(description);
        driver.setCar(car);

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

    @PostMapping(path = "/sync")
    public void syncLocations() {

    }
}
