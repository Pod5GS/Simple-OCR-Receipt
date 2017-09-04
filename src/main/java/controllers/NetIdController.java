package controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/netid")
@Produces(MediaType.TEXT_PLAIN)
public class NetIdController {
    final String netId;
    public NetIdController(String netId){
        this.netId = netId;
    }

    @GET
    public String getNetId(){
        return netId;
    }
}
