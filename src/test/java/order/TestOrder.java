package order;

import infrastructure.DataSourceConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test the infrastructure and integration of modules/components etc.
 *
 * @author tlang
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DataSourceConfiguration.class)
@Slf4j
public class TestOrder {

    @Autowired
    private IOrderService orderService;

    @Test
    public void createNewOrder() {
        Order newOrder = new Order("Thomas Lang", "Technische Hochschule Deggendorf");
        assertThat(newOrder).isNotNull();
        log.error(newOrder.toString());
        boolean b = orderService.newOrder(newOrder);
        assertThat(b).isTrue();
    }
}
