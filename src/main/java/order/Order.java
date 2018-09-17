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
@Builder
@ToString
public class Order {

    @Id
    private final UUID orderId = null;

    private String orderRecipient;

    private String orderSender;

    private LocalDate orderDate;

    private OrderState orderState;
}
