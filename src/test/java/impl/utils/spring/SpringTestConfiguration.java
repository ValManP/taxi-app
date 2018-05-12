package impl.utils.spring;

import impl.controller.*;
import impl.db.OrderRepository;
import impl.db.UserRepository;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@AutoConfigurationPackage
public class SpringTestConfiguration {

    public UserRepository userRepository;
    public OrderRepository orderRepository;

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

    @Bean
    OrderRepository orderRepository() {
        this.orderRepository = Mockito.mock(OrderRepository.class);
        return orderRepository;
    }

    @Bean
    UserRepository userRepository() {
        this.userRepository = Mockito.mock(UserRepository.class);
        return userRepository;
    }
}
