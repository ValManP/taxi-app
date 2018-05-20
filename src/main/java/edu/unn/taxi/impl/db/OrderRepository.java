package edu.unn.taxi.impl.db;

import edu.unn.taxi.impl.entity.Client;
import edu.unn.taxi.impl.entity.Driver;
import edu.unn.taxi.impl.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query("select o from orders o where o.driver is null")
    List<Order> findWithEmptyDriver();

    List<Order> findByClient(Client client);

    List<Order> findByDriver(Driver driver);
}
