package edu.unn.taxi.impl.db;

import edu.unn.taxi.impl.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query("select 1 from orders")
    List<Order> findWithEmptyDriver();
}
