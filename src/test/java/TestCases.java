import config.DataSourceConfiguration;
import lombok.extern.slf4j.Slf4j;
import model.Order;
import model.enumeration.OrderState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import service.IOrderService;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataSourceConfiguration.class)
@Slf4j
@AutoConfigureJdbc
public class TestCases {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private IOrderService orderService;

    @Test
    public void testIfDataSourceIsReady() throws SQLException {
        assertThat(dataSource).isNotNull();
        assertThat(dataSource.getConnection()).isNotNull();
        assertThat(dataSource.getConnection().getCatalog()).isEqualToIgnoringCase("jdbc-test");
    }

    @Test
    public void testIfServiceIsReady() {
        assertThat(orderService).isNotNull();

    }

    @Test
    public void testIfOrderGetsCreatded() {
        Order newOrder = Order.builder().orderDate(LocalDate.now()).orderRecipient("Thomas Lang").orderSender("Technische Hochschule Deggendorf").orderState(OrderState.OPEN).build();
        assertThat(newOrder).isNotNull();
        log.error(newOrder.toString());
        assertThat(orderService.newOrder(newOrder)).isTrue();

    }
}
