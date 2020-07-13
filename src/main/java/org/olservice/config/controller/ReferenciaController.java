package org.olservice.config.controller;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.olservice.config.Swagger;
import org.olservice.config.dto.DTOReferencia;
import org.olservice.config.mapper.ModelMapperUtil;
import org.olservice.config.model._Referencia;
import org.olservice.config.resource.ReferenciaResource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Type;
import java.util.List;

@Tag(ref = "Referencia")
@Path(Swagger.REFERENCIA)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReferenciaController {

    @Inject
    ReferenciaResource referenciaResource;

    ModelMapperUtil modelMapper;

    @GET
    @Path("/listar")
    public List<_Referencia> lista(DTOReferencia referencia){
        return (List<_Referencia>) referenciaResource.findAll();
    }

    @POST
    @Path("/salvar")
    public _Referencia salvar(DTOReferencia referencia){
        modelMapper  = new ModelMapperUtil();
       _Referencia referenciar = modelMapper.map(referencia, (Type) _Referencia.class);
        System.out.println(referenciar);
       return  null;
    }

    @PUT
    @Path("/editar")
    public void editar(DTOReferencia referencia) {


    }


}
