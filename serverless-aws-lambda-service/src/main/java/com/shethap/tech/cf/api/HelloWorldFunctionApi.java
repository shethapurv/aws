package com.shethap.tech.cf.api;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class HelloWorldFunctionApi {

    /**
     * Function implementation.
     * curl url: curl http://localhost:8080/welcome -H "Content-Type: text/plain" -d apurv
     *
     * @return Function
     */
    @Bean
    public Function<String, String> welcome() {
        return (userName) -> "Welcome " + userName + " to the functional programming";
    }


    /**
     * Consumer implementation.
     * curl url: curl http://localhost:8080/goodBye -H "Content-Type: text/plain" -d apurv
     *
     * @return Consumer
     */
    @Bean
    public Consumer<String> goodBye() {
        return (userName) -> System.out.println("See you soon " + userName);
    }

    /**
     * Supplier implementation
     * curl url: curl http://localhost:8080/supplier -H "Content-Type: text/plain"
     *
     * @return Supplier
     */
    @Bean
    public Supplier<String> supplier() {
        return () -> "This is supplier function";
    }
}
