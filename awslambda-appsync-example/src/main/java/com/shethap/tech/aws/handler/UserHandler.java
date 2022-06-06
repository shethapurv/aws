package com.shethap.tech.aws.handler;

import com.shethap.tech.aws.model.User;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class UserHandler extends SpringBootRequestHandler<User, Object> {
}
