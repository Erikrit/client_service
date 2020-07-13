package org.olservice.config.controller;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.olservice.config.Swagger;
import org.olservice.config.model._FeedBack;
import org.olservice.config.resource.FeedBackResource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Tag(ref = "Feedback")
@Path(Swagger.FEEDBACK)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FeedBackController {

    @Inject
    FeedBackResource feedBackResource;

    @GET
    @Path("/list")
    public List<_FeedBack> lista(){
        return (List<_FeedBack>) feedBackResource.findAll();
    }

    @POST
    @Path("/salvar")
    public void salvar(_FeedBack feedBack){
        feedBackResource.save(feedBack);
    }

    @PUT
    @Path("/editar")
    public void editar(_FeedBack feedBack) {
        if (feedBack.getId() != null) {
            feedBackResource.save(feedBack);
        }
    }
}
