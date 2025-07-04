package org.example.ee.rest;

import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(JsonObject jo){
        System.out.println(jo.getString("name"));

        return "ok";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(User user){
        System.out.println(user.getEmail());

        return "ok";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(Map user, @QueryParam("type") String type){

        return "ok";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@MatrixParam("type") Integer type){

        return "ok";
    }
}
