package com.example.exemple.jdbc.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jdbc")
@Getter
@Setter
public class JdbcProperties {
    private String username;
    private String password;
    private String InitSql;
    private JdbcDataSourceProperties rw;

    @Getter
    @Setter
    public static class JdbcDataSourceProperties {
        private String url;
        private Integer maxPoolSize;
        private Long maxLifetimeInMinutes;
        private Long leakDetectionThresholdInMilliseconds;
        private Long connectionTimeoutInMilliseconds;
    }
}
