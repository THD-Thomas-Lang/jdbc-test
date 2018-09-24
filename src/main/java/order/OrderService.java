package order;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The service layer to grant access to the database.
 *
 * @author tlang
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Transactional
public class OrderService implements IOrderService {

    private final @NonNull
    OrderRepository orderRepository;

    /**
     * Adds a new infrastucture.
     *
     * @param orderEntity the given infrastucture
     * @return boolean
     */
    @Override
    public boolean newOrder(OrderEntity orderEntity) {
        try {
            OrderEntity savedEntity = orderRepository.save(orderEntity);
            log.error(String.format("Saved entity: %s", savedEntity.toString()));
            return true;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return false;
        }

    }
}
