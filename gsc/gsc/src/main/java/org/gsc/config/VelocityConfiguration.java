package org.gsc.config;

import org.apache.velocity.spring.VelocityEngineFactoryBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VelocityConfiguration {

    
    public VelocityEngineFactoryBean velocityEngine() {
        VelocityEngineFactoryBean velocityEngine = new org.apache.velocity.spring.VelocityEngineFactoryBean();
        velocityEngine.setResourceLoaderPath("classpath:/templates");
        return velocityEngine;
    }
}

