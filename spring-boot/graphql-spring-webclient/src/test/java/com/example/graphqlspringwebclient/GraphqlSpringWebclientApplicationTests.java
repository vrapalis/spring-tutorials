package com.example.graphqlspringwebclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@SpringBootTest
class GraphqlSpringWebclientApplicationTests {

    @Autowired
    private WebClient webClient;

    @Autowired
    private GraphQLWebClient graphQLWebClient;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(webClient);
        Assertions.assertNotNull(graphQLWebClient);
    }

    @Test
    void callGraphQlServiceTest() {
        Object entity = graphQLWebClient.post("graphql/query1.graphql",
                Map.of("id", 8000108), Object.class).block();

        Assertions.assertNotNull(entity);
    }

    @TestConfiguration
    public static class AdditionTestConfiguration {

        @Bean
        public WebClient webClient() {
            return WebClient.builder()
                    .baseUrl("https://bahnql.herokuapp.com/graphql")
                    .defaultHeader("auth-token", "some-cryptic-code-if-required")
                    .build();
        }

        @Bean
        public GraphQLWebClient graphQLWebClient(WebClient webClient) {
            return GraphQLWebClient.newInstance(webClient, new ObjectMapper());
        }
    }
}
