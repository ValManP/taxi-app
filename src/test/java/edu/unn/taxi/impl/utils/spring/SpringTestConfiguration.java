package edu.unn.taxi.impl.utils.spring;

import edu.unn.taxi.impl.controller.*;
import edu.unn.taxi.impl.db.*;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@AutoConfigurationPackage
public class SpringTestConfiguration {

    public UserRepository userRepository;
    public OrderRepository orderRepository;
    public DriverRepository driverRepository;
    public ClientRepository clientRepository;
    public OperatorRepository operatorRepository;

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

    @Bean
    DriverRepository driverRepository() {
        this.driverRepository = Mockito.mock(DriverRepository.class);
        return driverRepository;
    }

    @Bean
    ClientRepository clientRepository() {
        this.clientRepository = Mockito.mock(ClientRepository.class);
        return clientRepository;
    }

    @Bean
    OperatorRepository operatorRepository() {
        this.operatorRepository = Mockito.mock(OperatorRepository.class);
        return operatorRepository;
    }
}
