package org.example.ee.jersey.config;

import org.example.ee.jersey.model.User;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DependencyBinder extends AbstractBinder {

    @Override
    protected void configure() {

        System.out.println("Dependency binder...");
        bind(User.class).to(User.class);
    }
}
