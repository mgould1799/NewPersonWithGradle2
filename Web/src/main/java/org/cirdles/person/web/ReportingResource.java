/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.person.web;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.List;
import javax.ws.rs.core.GenericEntity;

import org.cirdles.person.Person;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.simple.JSONObject;

import java.io.InputStream;


import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 *
 * @author meagangould
 */


@Path("service")
public class ReportingResource {
    
    private ReportingService reportingService; 
    
    public ReportingResource(){
        reportingService = new ReportingService(); 
    }


    @POST
    @Consumes("text/plain")
    @Produces(TEXT_PLAIN)
    public Response generate_reverse_get(
          //@FormDataParam("source") String text) throws Exception
          @DefaultValue("XYZ")@QueryParam("source") String text) throws Exception
    {
        String return_text= reportingService.reverse(text);

        return Response.ok(return_text).build();
    }

    @GET
    @Path("/reverse")
    @Consumes("text/plain")
    @Produces(TEXT_PLAIN)
    public Response generate_reverse_post(
            //@FormDataParam("source") String text) throws Exception
            @DefaultValue("XYZ")@QueryParam("source") String text) throws Exception
    {
        String return_text= reportingService.reverse(text);

        return Response.ok(return_text).build();
    }

    /**
     *
     */


    @POST
    @Path("/person")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add_to_dob(
            @DefaultValue("Bob") @FormDataParam("name") String name,
            @DefaultValue("22") @FormDataParam("DOB") String DOB)
            throws Exception
    {
        //http://zetcode.com/jersey/json/
        //https://www.tutorialspoint.com/redis/redis_java.htm
        Person person = new Person(name, Long.parseLong(DOB));
        Person return_person= reportingService.change_person_age(person);
        JSONObject return_value = new JSONObject();
        return_value.put("DOB",return_person.getDOB());
        return_value.put("name",return_person.getName());
        String jsonPersonString = return_value.toJSONString();
        return Response
                .ok(jsonPersonString)
                .build();
    }

    @POST
    @Path("/personFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.MULTIPART_FORM_DATA)
    public Response changeDOBFile(
            @FormDataParam("file") InputStream input){
        java.nio.file.Path pathToPerson = reportingService.generatePerson(input);
        File returnFile = pathToPerson.toFile();
        return Response.ok(returnFile).build();
    }
    
    
}






