package org.olservice.config.controller;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.olservice.config.Swagger;
import org.olservice.config.model._Ajuda;
import org.olservice.config.resource.AjudaResource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Tag(ref = "Ajuda")
@Path(Swagger.AJUDA)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AjudaController {

    @Inject
    AjudaResource ajudaService;

    @GET
    @Path("/listar")
    @RolesAllowed("user")
    public List<_Ajuda> lista() throws Exception {
   return (List<_Ajuda>) ajudaService.findAll();
    }

    @POST
    @Path("/salvar")
    public void salvar(_Ajuda ajuda){
        ajudaService.save(ajuda);
    }

    @PUT
    @Path("/editar")
    public void editar(_Ajuda ajuda){
        if(ajuda.getId()!= null){
            ajudaService.save(ajuda);
        }
    }



}
