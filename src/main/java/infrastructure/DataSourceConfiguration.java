package infrastructure;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.JdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

/**
 * Configures the datasource bean for spring data jdbc repositories.
 * Under the hood there is a usage of testcontainers, mocking "real" databases on docker images.
 * taken from: org.springframework.data.jdbc.testing.PostgresDataSourceConfiguration
 *
 * @author tlang
 * @see <a href="https://github.com/spring-projects/spring-data-jdbc">Spring Data JDBC</a>
 * @see <a href="https://spring.io/blog/2018/09/17/introducing-spring-data-jdbc">Introduction to Spring Data JDBC</a>
 */
@Configuration
@EnableJdbcRepositories("order")
@ComponentScan("order")
public class DataSourceConfiguration extends JdbcConfiguration {

    private static final PostgreSQLContainer POSTGRESQL_CONTAINER = new PostgreSQLContainer();

    static {
        POSTGRESQL_CONTAINER.start();
    }

    /**
     * New bean:
     * Taken from here: https://spring.io/blog/2018/09/17/introducing-spring-data-jdbc
     *
     * @return NamedParameterJdbcOperations
     */
    @Bean
    NamedParameterJdbcOperations operations() {
        return new NamedParameterJdbcTemplate(postgresqlDataSource());
    }

    /**
     * New bean:
     * Taken from here: https://spring.io/blog/2018/09/17/introducing-spring-data-jdbc
     *
     * @return PlatformTransactionManager
     */
    @Bean
    PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(postgresqlDataSource());
    }

    /**
     * Exposes a datasource based on a specific mock database.
     *
     * @return DataSource
     */
    @Bean
    DataSource postgresqlDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(POSTGRESQL_CONTAINER.getJdbcUrl());
        dataSource.setUser(POSTGRESQL_CONTAINER.getUsername());
        dataSource.setPassword(POSTGRESQL_CONTAINER.getPassword());
        return dataSource;
    }
}
