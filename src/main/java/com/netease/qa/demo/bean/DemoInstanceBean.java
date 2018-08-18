package com.netease.qa.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by KentZhong on 09/07/2018.
 */
@Component
@ConfigurationProperties(prefix = "kent")
@PropertySource(value = "classpath:instance.properties", ignoreResourceNotFound=false)
public class DemoInstanceBean {
//    @Value(value = "${instanceName}")
    private String instanceName;
//    @Value(value = "${instanceOwner}")
    private String instanceOwner;

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getInstanceOwner() {
        return instanceOwner;
    }

    public void setInstanceOwner(String instanceOwner) {
        this.instanceOwner = instanceOwner;
    }
}
