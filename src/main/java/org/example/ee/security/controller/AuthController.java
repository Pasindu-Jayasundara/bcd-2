package org.example.ee.security.controller;

import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.ee.security.security.Credentials;
import org.example.ee.security.service.LoginService;
import org.example.ee.security.util.JWTUtil;

import java.util.Set;

@Path("/auth")
public class AuthController {

    @Inject
    private LoginService loginService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Credentials credentials){

        if(loginService.validate(credentials.getUsername(), credentials.getPassword())){

            Set<String> roles = loginService.getRoles(credentials.getUsername());
            String token = JWTUtil.generateToken(credentials.getUsername(), roles);

            JsonObject jsonObject = Json.createObjectBuilder()
                    .add("token",token).build();

            return Response.ok(jsonObject).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(String json){

        return Response.ok().build();
    }
}
