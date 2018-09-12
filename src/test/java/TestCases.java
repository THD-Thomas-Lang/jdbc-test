import config.DataSourceConfiguration;
import lombok.extern.slf4j.Slf4j;
import model.Order;
import model.enumeration.OrderState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import service.OrderRepository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataSourceConfiguration.class)
@Slf4j
public class TestCases {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testIfDataSourceIsReady() {
        assertThat(dataSource).isNotNull();
        try {
            log.error(dataSource.getConnection().getCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOrderCreation() {
        Order newOrder = Order.builder().orderDate(LocalDate.now()).orderRecipient("Thomas Lang").orderSender("Technische Hochschule Deggendorf").orderState(OrderState.OPEN).build();
        assertThat(newOrder).isNotNull();

    }
}
