package order;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__(@PersistenceConstructor))
@NoArgsConstructor
@ToString
public class OrderEntity {

    @Id
    private final UUID order_id = null;

    private String order_recipient;

    private String order_sender;

    private LocalDate order_date = LocalDate.now();

    private OrderState order_state = OrderState.OPEN;

    /**
     * Overloaded constructor.
     * Builds a new order based on the given recipient and sender.
     *
     * @param orderRecipient a given recipient
     * @param orderSender    a given sender
     */
    OrderEntity(String orderRecipient, String orderSender) {
        this();
        this.order_recipient = orderRecipient;
        this.order_sender = orderSender;
    }
}
