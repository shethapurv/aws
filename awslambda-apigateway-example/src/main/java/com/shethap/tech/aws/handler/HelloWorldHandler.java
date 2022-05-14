package com.shethap.tech.aws.handler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class HelloWorldHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, String> {
}
