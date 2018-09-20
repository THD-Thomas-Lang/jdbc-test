package order;


public interface IOrderService {

    /**
     * Adds a new infrastucture.
     *
     * @param orderEntity the given infrastucture
     * @return boolean
     */
    boolean newOrder(OrderEntity orderEntity);
}
