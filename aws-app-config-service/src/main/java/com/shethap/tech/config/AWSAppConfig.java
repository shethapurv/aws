package com.shethap.tech.config;

import com.amazonaws.services.appconfig.AmazonAppConfig;
import com.amazonaws.services.appconfig.AmazonAppConfigClient;
import com.amazonaws.services.appconfig.model.GetConfigurationRequest;
import com.amazonaws.services.appconfig.model.GetConfigurationResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

@Configuration
public class AWSAppConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(AWSAppConfig.class);

    private final AmazonAppConfig appConfig;
    private final GetConfigurationRequest request;

    public AWSAppConfig() {
        appConfig = AmazonAppConfigClient.builder().build();
        request = new GetConfigurationRequest();
        request.setClientId("clientId");
        request.setApplication("aws-app-config-service");
        request.setConfiguration("dev");
        request.setEnvironment("dev");
    }

    public String getConfiguration() throws UnsupportedEncodingException {
        GetConfigurationResult result = appConfig.getConfiguration(request);
        String message = String.format("contentType: %s", result.getContentType());
        LOGGER.info(message);

        if (!Objects.equals("application/json", result.getContentType())) {
            throw new IllegalStateException("config is expected to be JSON");
        }

        String content = new String(result.getContent().array(), "ASCII");
        return content;
    }
}
