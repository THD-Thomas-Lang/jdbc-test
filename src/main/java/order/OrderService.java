package order;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service layer to grant access to the database.
 *
 * @author tlang
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class OrderService implements IOrderService {

    private final @NonNull
    OrderRepository orderRepository;

    /**
     * Adds a new infrastucture.
     *
     * @param order the given infrastucture
     * @return boolean
     */
    @Override
    public boolean newOrder(Order order) {
        try {
            orderRepository.save(order);
            return true;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return false;
        }

    }
}
