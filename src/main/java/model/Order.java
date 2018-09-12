package model;

import lombok.*;
import model.enumeration.OrderState;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__(@PersistenceConstructor))
@NoArgsConstructor
@Builder
public class Order {

    @Id
    private final UUID orderId = UUID.randomUUID();

    private String orderRecipient;

    private String orderSender;

    private LocalDate orderDate;

    private OrderState orderState;
}