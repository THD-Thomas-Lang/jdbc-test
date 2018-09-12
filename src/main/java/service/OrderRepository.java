package service;


import model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Kept package private so that the direct data access is only possible via @Service layer.
 *
 * @author tlang
 */
interface OrderRepository extends CrudRepository<Order, UUID> {
}
