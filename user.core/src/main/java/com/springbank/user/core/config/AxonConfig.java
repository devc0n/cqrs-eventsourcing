package com.springbank.user.core.config;

import com.mongodb.client.MongoClient;
import lombok.var;
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoFactory;
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoSettingsFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Value("{spring.data.mongodb.host:127.0.0.1}")
    private String mongoHost;

    @Value("{spring.data.mongodb.port:27017}")
    private int mongoPort;

    @Value("{spring.data.mongodb.database:user}")
    private String mongoDatabase;

    @Bean
    public MongoClient mongo(){
        var mongoFactory = new MongoFactory();
        var mongoSettingsFactory = new MongoSettingsFactory();

        mongoSettingsFactory.
    }


}