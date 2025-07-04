package org.example.ee.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

@Path("/")
public class Home {

    @GET
    public String home(){
        System.out.println("home");
        return "Hello World";
    }

    @Path("user")
    @GET
    public String user(){
        return "user";
    }
}
