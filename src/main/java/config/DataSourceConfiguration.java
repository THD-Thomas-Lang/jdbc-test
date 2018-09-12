package config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJdbcRepositories("service")
public class DataSourceConfiguration {

    /**
     * Setting the data source bean.
     *
     * @return DataSource
     */
    @Bean
    public DataSource PostgresqlDataSource() {
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        pgSimpleDataSource.setServerName("localhost");
        pgSimpleDataSource.setDatabaseName("jdbc-test");
        pgSimpleDataSource.setUser("postgres");
        pgSimpleDataSource.setPassword("admin");
        return pgSimpleDataSource;
    }
}
