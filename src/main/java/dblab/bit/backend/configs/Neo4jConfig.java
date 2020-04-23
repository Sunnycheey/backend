package dblab.bit.backend.configs;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: backend
 * @description: config class for neo4j
 * @author: lihuichao
 * @create: 2020-04-23
 **/

@Configuration
public class Neo4jConfig {
    @Bean
    public SessionFactory getSessionFactory() {
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder().uri("http://47.98.184.87:7474")
                .credentials("neo4j", "123")
                .build();

        SessionFactory sessionFactory = new SessionFactory(configuration, "dblab.bit.backend.models");
        return sessionFactory;
    }
}