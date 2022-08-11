package com.shethap.tech.rest;

import com.shethap.tech.config.AWSAppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(path = "/aws", method = RequestMethod.GET)
public class AWSAppConfigController {

    @Autowired
    AWSAppConfig awsAppConfig;

    @RequestMapping(path = "/getConfig", method = RequestMethod.GET)
    public String getAWSAppConfig() throws UnsupportedEncodingException {
        return awsAppConfig.getConfiguration();

    }
}
