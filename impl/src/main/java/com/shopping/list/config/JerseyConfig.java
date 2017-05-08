package com.shopping.list.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/shopping-list-app")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
    }
}
