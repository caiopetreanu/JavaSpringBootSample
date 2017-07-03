package br.com.caiopetreanu.AvenueCodeRecruitment.controller;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by Caio Catanzaro Petreanu on 03/07/2017.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(ProductController.class);
        register(ProductsController.class);
        register(ImageController.class);
        register(ImagesController.class);
    }
}
