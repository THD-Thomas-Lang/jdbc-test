package infrastucture;

import infrastructure.DataSourceConfiguration;
import lombok.extern.slf4j.Slf4j;
import order.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = DataSourceConfiguration.class)
// The following is needed because of this:
// Parameter 0 of method setJdbcOperations in org.springframework.data.jdbc.repository.support.JdbcRepositoryFactoryBean required a bean of type 'org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations' that could not be found.
@Slf4j
public class TestInfrastructure {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private DataSource dataSource;

    /**
     * Test if the service is ready.
     */
    @Test
    public void testIfServiceIsReady() {
        assertThat(orderService).isNotNull();

    }

    /**
     * Test if the service is ready.
     */
    @Test
    public void testIfDataSourceIsReady() {
        assertThat(dataSource).isNotNull();

    }

//    /**
//     * This test currently fails:
//     * Executing prepared SQL statement [UPDATE infrastucture SET order_id = ?, order_recipient = ?, order_sender = ?, order_date = ?, order_state = ? WHERE order_id = ?]
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

//    @Test
//    public void testIfOrderGetsCreatdedWhenUUIDIsNotSet() {
//        Order newOrder = Order.builder().orderDate(LocalDate.now()).orderRecipient("Thomas Lang").orderSender("Technische Hochschule Deggendorf").orderState(OrderState.OPEN).build();
//        assertThat(newOrder).isNotNull();
//        log.error(newOrder.toString());
//        assertThat(orderService.newOrder(newOrder)).isTrue();
//
//    }

//    // taken from here: https://github.com/testcontainers/testcontainers-java/blob/master/modules/jdbc-test/src/test/java/org/testcontainers/junit/SimplePostgreSQLTest.java
//    @Rule
//    public PostgreSQLContainer postgres = new PostgreSQLContainer();
//
//    // taken from here: https://github.com/testcontainers/testcontainers-java/blob/master/modules/jdbc-test/src/test/java/org/testcontainers/junit/SimplePostgreSQLTest.java
//    @Test
//    public void testSimple() throws SQLException {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl(postgres.getJdbcUrl());
//        hikariConfig.setUsername(postgres.getUsername());
//        hikariConfig.setPassword(postgres.getPassword());
//
//        HikariDataSource ds = new HikariDataSource(hikariConfig);
//        Statement statement = ds.getConnection().createStatement();
//        statement.execute("SELECT 1");
//        ResultSet resultSet = statement.getResultSet();
//
//        resultSet.next();
//        int resultSetInt = resultSet.getInt(1);
//        assertEquals("A basic SELECT query succeeds", 1, resultSetInt);
//    }
}
