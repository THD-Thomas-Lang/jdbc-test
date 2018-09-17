package order;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__(@PersistenceConstructor))
@NoArgsConstructor
@ToString
public class Order {

    @Id
    private final long orderId = 0;

    private String orderRecipient;

    private String orderSender;

    private LocalDate orderDate = LocalDate.now();

    private OrderState orderState = OrderState.OPEN;

    /**
     * Overloaded constructor.
     * Builds a new order based on the given recipient and sender.
     *
     * @param orderRecipient a given recipient
     * @param orderSender    a given sender
     */
    public Order(String orderRecipient, String orderSender) {
        this();
        this.orderRecipient = orderRecipient;
        this.orderSender = orderSender;
    }
}
