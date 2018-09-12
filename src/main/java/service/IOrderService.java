package service;

import model.Order;

public interface IOrderService {

    /**
     * Adds a new order.
     *
     * @param order the given order
     * @return boolean
     */
    boolean newOrder(Order order);
}
