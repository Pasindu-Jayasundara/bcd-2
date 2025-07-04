package org.example.ee.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

@Path("/users")
public class UserResource {

    @GET
    public List<String> getUsers(){
        return Arrays.asList(new String[]{"a","b","c"});
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String getUser(@PathParam("id") String id){
        return id;
    }
}
