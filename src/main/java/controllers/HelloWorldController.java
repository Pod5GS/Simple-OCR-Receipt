package controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

// For a Java class to be eligible to receive ANY requests
// it must be annotated with at least @Path
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldController {

    // You can specify additional @Path steps; they will be relative
    // to the @Path defined at the class level
    @GET
    @Path("/hello")
    public String helloWorld() {
        return "Hello World";
    }
}
