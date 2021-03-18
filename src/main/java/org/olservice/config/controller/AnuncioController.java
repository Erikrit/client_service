package org.olservice.config.controller;

import com.dropbox.core.DbxException;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.olservice.config.Swagger;
import org.olservice.config.dto.*;
import org.olservice.config.model._Anuncio;
import org.olservice.config.resource.AnuncioResource;
import org.olservice.config.service.AnunciosService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Tag(ref = "Anuncio")
@Path(Swagger.ANUNCIO)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnuncioController {

    @Inject
    AnunciosService anunciosService;


    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTOAnuncio> lista() {
        return anunciosService.buscarAnuncio();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/salvar")
    public void salvar(DTOAnuncio anuncio) throws IOException, DbxException {
        anunciosService.salvarAnuncio(anuncio);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editar")
    public void editar(DTOAnuncio anuncio) throws IOException, DbxException {
        anunciosService.editarAnuncio(anuncio);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deletar")
    public void deletar(Long id) throws IOException, DbxException {
        anunciosService.deletarAnuncio(id);
    }
    @POST
    @Path("/salvar/anexo/{id}")
    public void anexo(@PathParam(value = "id") String id) throws IOException, JAXBException {

    }

    @POST
    @Path("/buscar/filtro2")
    public List<DTOAnuncio> filtrarAnuncio2(DTOFiltro2 filtro) {
        return anunciosService.buscarComFiltro2(filtro);
    }
    @GET
    @Path("/meu-anuncio/{id}")
    public List<DTOAnuncio> meusAnuncio(@PathParam(value = "id") String id){
        if(id==null){
            throw new WebApplicationException("Id usuario nao pode ser null.", 404);
        }
        return  anunciosService.meusAnuncios(Integer.parseInt(id));
    }
    @GET
    @Path("/meu-feedback/{id}")
    public List<DTOAnuncio> buscarFeedback(@PathParam(value = "id") String id){
        if(id==null){
            throw new WebApplicationException("Id usuario nao pode ser null.", 404);
        }
        return  anunciosService.buscarFeedback(Integer.parseInt(id));
    }
    @POST
    @Path("/salvar-favoritos")
    public void salvarFavoritos(DTOFavorito favorito){
        if(favorito.getIdAnuncio()==null ||favorito.getIdUsuario()==null){
            throw new WebApplicationException("Id usuario nao pode ser null.", 404);
        }
        anunciosService.salvarFavoritos(favorito);

    }
    @POST
    @Path("/remover-favoritos")
    public void removerFavoritos(DTOFavorito favorito){
        if(favorito.getIdAnuncio()==null ||favorito.getIdUsuario()==null){
            throw new WebApplicationException  ("Id usuario nao pode ser null.", 404);
        }
        anunciosService.removerFavoritos(favorito);
    }
    @POST
    @Path("/feedback")
    public void feedback(DTOFeedback feedback) {
         anunciosService.salvarComentario(feedback);
    }

}
