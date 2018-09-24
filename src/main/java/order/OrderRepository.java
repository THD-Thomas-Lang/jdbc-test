package order;


import org.springframework.data.repository.CrudRepository;

/**
 * Kept package private so that the direct data access is only possible via @Service layer.
 *
 * @author tlang
 */
interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
