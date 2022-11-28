package com.example.exemple.jdbc.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Driver;
@Configuration
public class JdbcConfiguration {
    private final JdbcProperties jdbcProperties;

    public JdbcConfiguration(final JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }



    @Bean
    @Primary
    @Qualifier("rwDataSource")
    public DataSource rwDataSource() {
        return createDataSource(this.jdbcProperties.getRw());
    }

    @Bean
    @Primary
    @Qualifier("rwDataSource")
    public NamedParameterJdbcTemplate rwJdbcTemplate(@Qualifier("rwDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }


    private HikariDataSource createDataSource(final JdbcProperties.JdbcDataSourceProperties dataSourceProperties) {
        final HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(this.jdbcProperties.getUsername());
        dataSource.setPassword(this.jdbcProperties.getPassword());
        dataSource.setMaximumPoolSize(dataSourceProperties.getMaxPoolSize());
        dataSource.setMaxLifetime(dataSourceProperties.getMaxLifetimeInMinutes());
        dataSource.setLeakDetectionThreshold(dataSourceProperties.getLeakDetectionThresholdInMilliseconds());
        dataSource.setConnectionTimeout(dataSourceProperties.getConnectionTimeoutInMilliseconds());
        dataSource.setConnectionInitSql(this.jdbcProperties.getInitSql());
        return dataSource;
    }
}
