package org.example.fifa.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private final static int defaultPort = 5432;
    private final String user = System.getenv("DB_USER");
    private final String password = System.getenv("DB_PASSWORD");
    private final String host = System.getenv("DB_HOST");
    private final String database = System.getenv("DB_NAME");

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://" + host + ":" + defaultPort + "/" + database);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }
}
