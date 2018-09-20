package order;

import infrastructure.DataSourceConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
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
@Sql(scripts = "classpath:schema.sql")
public class TestOrderEntity {

    @Autowired
    private IOrderService orderService;

    @Test
    public void createNewOrder() {
        OrderEntity newOrderEntity = new OrderEntity("Thomas Lang", "Technische Hochschule Deggendorf");
        assertThat(newOrderEntity).isNotNull();
        log.error(newOrderEntity.toString());
        boolean b = orderService.newOrder(newOrderEntity);
        assertThat(b).isTrue();
    }
}
