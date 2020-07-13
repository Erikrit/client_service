package org.olservice.config.controller;


import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.olservice.config.Swagger;
import org.olservice.config.service.CategoriaService;
import org.olservice.config.model._Categoria;
import org.olservice.config.resource.CategoriaResource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Tag(ref = "Categoria")
@Path(Swagger.CATEGORIA)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaController {


    @Inject
    CategoriaResource categoriaResource;

    @Inject
    CategoriaService categoriaService;

    @GET
    @Path("/list")
    public List<_Categoria> lista(){
        return (List<_Categoria>) categoriaService.listCategoria();
    }

    @POST
    @Path("/salvar")
    public void salvar(_Categoria categoria){
        categoriaResource.save(categoria);
    }

    @PUT
    @Path("/editar")
    public void editar(_Categoria categoria){
        if(categoria.getId()!= null){
            categoriaResource.save(categoria);
        }
    }

    @GET
    @Path("/list/categoriaPai/{id}")
    public List<_Categoria> listSubCategoria(@PathParam(value = "id")long id){
        return categoriaService.listSubCategoria(id);
    }
}
