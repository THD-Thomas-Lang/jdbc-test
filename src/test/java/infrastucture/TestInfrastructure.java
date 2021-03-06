package infrastucture;

import infrastructure.DataSourceConfiguration;
import lombok.extern.slf4j.Slf4j;
import order.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test the infrastructure and integration of modules/components etc.
 *
 * @author tlang
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DataSourceConfiguration.class)
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

}
