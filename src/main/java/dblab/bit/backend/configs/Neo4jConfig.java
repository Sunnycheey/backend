package dblab.bit.backend.configs;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: backend
 * @description: config class for neo4j
 * @author: lihuichao
 * @create: 2020-04-23
 **/

@Configuration
@EnableNeo4jRepositories(basePackages = "dblab.bit.backend.repository")
@EnableTransactionManagement
public class Neo4jConfig {
    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder().uri("http://47.98.184.87:7474")
                .credentials("neo4j", "123")
                .build();
        return configuration;
    }

    @Bean
    public SessionFactory sessionFactory() {
        SessionFactory sessionFactory = new SessionFactory(configuration(), "dblab.bit.backend.models");
        return sessionFactory;
    }

}