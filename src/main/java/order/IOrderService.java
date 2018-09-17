package order;


public interface IOrderService {

    /**
     * Adds a new infrastucture.
     *
     * @param order the given infrastucture
     * @return boolean
     */
    boolean newOrder(Order order);
}
