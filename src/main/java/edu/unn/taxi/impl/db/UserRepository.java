package edu.unn.taxi.impl.db;

import edu.unn.taxi.impl.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository<T extends User> extends CrudRepository<T, Integer> {
}
