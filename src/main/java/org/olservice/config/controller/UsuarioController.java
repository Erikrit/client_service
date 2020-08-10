package org.olservice.config.controller;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.olservice.config.Swagger;
import org.olservice.config.dto.DTOLogin;
import org.olservice.config.dto.DTOUsuario;
import org.olservice.config.model._Usuario;
import org.olservice.config.resource.UsuarioResource;
import org.olservice.config.service.UsuarioService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(ref = "Usuario")
@Path(Swagger.USUARIO)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioController {

    @Inject
    UsuarioResource usuarioResource;
    @Inject
    UsuarioService usuarioService;


    @GET
    @Path("/listar")
    public List<_Usuario> lista(){
        return (List<_Usuario>) usuarioResource.findAll();
    }

    @POST
    @Path("/salvar")
    public void salvar(DTOUsuario usuario){
        usuarioService.salvarUsuario(usuario);
    }

    @PUT
    @Path("/editar")
    public void editar(DTOUsuario usuario) {
        if (usuario.getId() != null) {
            usuarioService.editar(usuario);
        }
    }
    @POST
    @Path("/verificar")
    public DTOUsuario verificar(DTOLogin login) throws Exception {
        return usuarioService.verificarUsuario(login);
    }
    @POST
    @Path("/atualizar-Usuario")
    public DTOUsuario atualizarUsuario(long idUsuario) throws Exception {
        return usuarioService.atualizarUsuario(idUsuario);
    }
    @Inject
    Mailer mailer;
    
    @GET
    @Path("/TesteEmail")
    public Response sendASimpleEmail() {
        mailer.send(Mail.withText("Erikri_1995@hotmail.com", "A simple email from quarkus", "This is my body"));
        return Response.accepted().build();
    }
}
