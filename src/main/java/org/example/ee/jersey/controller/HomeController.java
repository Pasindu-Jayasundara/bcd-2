package org.example.ee.jersey.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.io.FilenameUtils;
import org.example.ee.jersey.model.User;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.mvc.Viewable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Path("/")
public class HomeController {

    @Inject
    User user;

    @Context
    ServletContext servletContext;

    @GET
    public Viewable index(){

        System.out.println(user);

        Map<String,Object> model = new HashMap<>();
        model.put("a","aaaaaaaaaaaaaaaaa");

        return new Viewable("/index",model);
    }

    @POST
    @Path("/file_upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response singleFileUpload(@FormDataParam("file") FormDataBodyPart body){

        InputStream is = body.getContent();
        // body.getContentDisposition();// meta data
        String fileName = body.getContentDisposition().getFileName();
        String extension = FilenameUtils.getExtension(fileName);

        try{

            int read = 0;
            byte[] buffer = new byte[1024];

            String realPath = servletContext.getRealPath("/");
            java.nio.file.Path uploadPath = Paths.get(realPath+"/upload");

            if(!Files.exists(uploadPath)){
                try{
                    Files.createDirectory(uploadPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            File file = new File(realPath+"/" + System.currentTimeMillis() + "." + extension);
            FileOutputStream outputStream = new FileOutputStream(file);

            while((read = is.read(buffer)) != -1){
                outputStream.write(buffer,0,read);
            }

            outputStream.flush();
            outputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return Response.ok().build();
    }

    @POST
    @Path("/multiple_file_upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response multipleFileUpload(@FormDataParam("file") FormDataBodyPart body){

        body.getParent().getBodyParts().forEach(bodyPart -> {

            InputStream is = bodyPart.getEntityAs(InputStream.class);

            String fileName = body.getContentDisposition().getFileName();
            String extension = FilenameUtils.getExtension(fileName);


            try{

                int read = 0;
                byte[] buffer = new byte[1024];

                String realPath = servletContext.getRealPath("/");
                java.nio.file.Path uploadPath = Paths.get(realPath+"/upload");

                if(!Files.exists(uploadPath)){
                    try{
                        Files.createDirectory(uploadPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                File file = new File(realPath+"/" + System.currentTimeMillis() + "." + extension);
                FileOutputStream outputStream = new FileOutputStream(file);

                while((read = is.read(buffer)) != -1){
                    outputStream.write(buffer,0,read);
                }

                Thread.sleep(100);

                outputStream.flush();
                outputStream.close();

            }catch (IOException e){
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        return Response.ok().build();
    }
}
