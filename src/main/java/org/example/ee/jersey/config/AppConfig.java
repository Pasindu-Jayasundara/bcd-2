package org.example.ee.jersey.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

//@ApplicationPath("/")
public class AppConfig extends ResourceConfig {

    public AppConfig(){

        packages("org.example.ee.jersey.controller");
        packages("org.example.ee.jersey.middleware");

        register(JspMvcFeature.class);
        property(JspMvcFeature.TEMPLATE_BASE_PATH,"/WEb-INF/views");
    }
}
