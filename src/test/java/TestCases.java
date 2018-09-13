import config.DataSourceConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import service.IOrderService;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataSourceConfiguration.class)
// The following is needed because of this:
// Parameter 0 of method setJdbcOperations in org.springframework.data.jdbc.repository.support.JdbcRepositoryFactoryBean required a bean of type 'org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations' that could not be found.
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
//
//    @Test
//    public void testIfOrderGetsCreatded() {
//        Order newOrder = Order.builder().orderDate(LocalDate.now()).orderRecipient("Thomas Lang").orderSender("Technische Hochschule Deggendorf").orderState(OrderState.OPEN).build();
//        assertThat(newOrder).isNotNull();
//        log.error(newOrder.toString());
//        assertThat(orderService.newOrder(newOrder)).isTrue();
//
//    }
}
