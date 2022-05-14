package com.shethap.tech.aws.api;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class HelloWorldFunctionApi {

    /**
     * Function implementation.
     *
     * @return Function
     */
    @Bean
    public Function<APIGatewayProxyRequestEvent, String> welcome() {
        return (requestEvent) -> "Welcome " + requestEvent.getQueryStringParameters().get("userName") + " to the functional programming";
    }


    /**
     * Consumer implementation.
     *
     * @return Consumer
     */
    @Bean
    public Consumer<String> goodBye() {
        return (userName) -> System.out.println("See you soon " + userName);
    }

    /**
     * Supplier implementation
     *
     * @return Supplier
     */
    @Bean
    public Supplier<String> supplier() {
        return () -> "This is supplier function";
    }
}
