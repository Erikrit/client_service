package org.olservice.config.controller;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.olservice.config.Swagger;
import org.olservice.config.model._Classificacao;
import org.olservice.config.resource.ClassificacaoResource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Tag(ref = "Classificacao")
@Path(Swagger.CLASSIFICACAO)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClassificacaoController {

    @Inject
    ClassificacaoResource classificacaoResource;

    @GET
    @Path("/list")
    public List<_Classificacao> lista(){
        return (List<_Classificacao>) classificacaoResource.findAll();
    }

    @POST
    @Path("/salvar")
    public void salvar(_Classificacao classificacao){
        classificacaoResource.save(classificacao);
    }

    @PUT
    @Path("/editar")
    public void editar(_Classificacao classificacao) {
        if (classificacao.getId() != null) {
            classificacaoResource.save(classificacao);
        }
    }
}
