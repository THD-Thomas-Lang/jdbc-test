package service;


import model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface OrderRepository extends CrudRepository<Order, UUID> {
}
