package edu.unn.taxi.impl.utils.spring;

import edu.unn.taxi.impl.controller.*;
import org.springframework.context.annotation.Bean;

//@SpringBootConfiguration
//@AutoConfigurationPackage
public class SpringTestConfiguration {
    @Bean
    OrderController orderController() {
        return new OrderController();
    }

    @Bean
    DriverController driverController() {
        return new DriverController();
    }

    @Bean
    UserController userController() {
        return new UserController();
    }

    @Bean
    OperatorController operatorController() {
        return new OperatorController();
    }

    @Bean
    ClientController clientController() {
        return new ClientController();
    }
}
