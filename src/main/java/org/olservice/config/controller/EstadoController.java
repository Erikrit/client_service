//package org.olservice.config.controller;
//
//import org.eclipse.microprofile.openapi.annotations.tags.Tag;
//import org.olservice.config.Swagger;
//import org.olservice.config.model._Anuncio;
//import org.olservice.config.model._Estado;
//import org.olservice.config.resource.EstadoResource;
//
//import javax.inject.Inject;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import java.util.List;
//
//@Tag(ref = "Estado")
//@Path(Swagger.ESTADO)
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
//public class EstadoController {
//
////
////    @Inject
////    private EstadoResource estadoResource;
////
////    @GET
////    @Path("/listar")
////    public List<_Estado> lista(){
////        return (List<_Estado>) estadoResource.findAll();
////    }
////
////    @POST
////    @Path("/salvar")
////    public void salvar(_Estado estado){
////        estadoResource.save(estado);
////    }
////
////    @PUT
////    @Path("/editar")
////    public void editar(_Estado estado) {
////        if (estado.getId() != null) {
////            estadoResource.save(estado);
////        }
////    }
//
//
//}
