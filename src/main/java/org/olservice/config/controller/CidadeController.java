//package org.olservice.config.controller;
//
//import org.eclipse.microprofile.openapi.annotations.tags.Tag;
//import org.olservice.config.Swagger;
//import org.olservice.config.model._Cidade;
//import org.olservice.config.model._Estado;
//import org.olservice.config.resource.CidadeResource;
//import org.olservice.config.resource.EstadoResource;
//import org.olservice.config.service.CidadeService;
//import org.springframework.stereotype.Controller;
//
//import javax.inject.Inject;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import java.util.List;
//
//@Tag(ref = "CIDADE")
//@Path(Swagger.CIDADE)
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
//public class CidadeController {
//
////
////    @Inject
////    private CidadeResource estadoResource;
////
////    @Inject
////    private CidadeService cidadeService;
////
////    @GET
////    @Path("/listar")
////    public List<_Cidade> lista(){
////        return (List<_Cidade>) estadoResource.findAll();
////    }
////
////    @POST
////    @Path("/salvar")
////    public void salvar(_Cidade cidade){
////        estadoResource.save(cidade);
////    }
////
////    @PUT
////    @Path("/editar")
////    public void editar(_Cidade cidade) {
////        if (cidade.getId() != null) {
////            estadoResource.save(cidade);
////        }
////    }
////    @GET
////    @Path("/listar/uf/{idUf}")
////    public List<_Cidade> lista(
////            @PathParam(value = "idUf")
////            long idUf){
////        return (List<_Cidade>) cidadeService.listCidadePorEstado(idUf);
////    }
//
//}
