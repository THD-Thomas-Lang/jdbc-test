package order;

import lombok.*;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__(@PersistenceConstructor))
@ToString
@Table("order_entity")
public class OrderEntity {

    private final @Id
    @Wither
    long order_id;

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
        this.order_id = 0;
        this.order_recipient = orderRecipient;
        this.order_sender = orderSender;
    }
}
