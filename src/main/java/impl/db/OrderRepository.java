package impl.db;

import impl.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query("select o from orders o where o.driver is null")
    List<Order> findWithEmptyDriver();
}
