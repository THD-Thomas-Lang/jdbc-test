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
// The following is needed because of this:
// Parameter 0 of method setJdbcOperations in org.springframework.data.jdbc.repository.support.JdbcRepositoryFactoryBean required a bean of type 'org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations' that could not be found.
@AutoConfigureJdbc
@Slf4j
public class TestCases {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private IOrderService orderService;

    /**
     * Checks if the setup datasource is ready ...
     *
     * @throws SQLException a given exception
     */
    @Test
    public void testIfDataSourceIsReady() throws SQLException {
        assertThat(dataSource).isNotNull();
        assertThat(dataSource.getConnection()).isNotNull();
        assertThat(dataSource.getConnection().getCatalog()).isEqualToIgnoringCase("jdbc-test");
    }

    /**
     * Test if the service is ready.
     */
    @Test
    public void testIfServiceIsReady() {
        assertThat(orderService).isNotNull();

    }

//    /**
//     * This test currently fails:
//     * Executing prepared SQL statement [UPDATE order SET order_id = ?, order_recipient = ?, order_sender = ?, order_date = ?, order_state = ? WHERE order_id = ?]
//     * It should do an insert
//     * The ID Property is set the following: private final UUID orderId = UUID.randomUUID();
//     */
//    @Test
//    public void testIfOrderGetsCreatdedWhenUUIDIsSet() {
//        Order newOrder = Order.builder().orderDate(LocalDate.now()).orderRecipient("Thomas Lang").orderSender("Technische Hochschule Deggendorf").orderState(OrderState.OPEN).build();
//        assertThat(newOrder).isNotNull();
//        log.error(newOrder.toString());
//        assertThat(orderService.newOrder(newOrder)).isTrue();
//
//    }

    @Test
    public void testIfOrderGetsCreatdedWhenUUIDIsNotSet() {
        Order newOrder = Order.builder().orderDate(LocalDate.now()).orderRecipient("Thomas Lang").orderSender("Technische Hochschule Deggendorf").orderState(OrderState.OPEN).build();
        assertThat(newOrder).isNotNull();
        log.error(newOrder.toString());
        assertThat(orderService.newOrder(newOrder)).isTrue();

    }
}
