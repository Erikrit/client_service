package org.olservice.config.service;


import org.olservice.config.Enum.EnumStatus;
import org.olservice.config.dto.DTOLogin;
import org.olservice.config.dto.DTOUsuario;
import org.olservice.config.mapper.ModelMapperUtil;
import org.olservice.config.model._Usuario;
import org.olservice.config.resource.UsuarioResource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsuarioService {

    ModelMapperUtil modelMapper;

    @Inject
    AnunciosService anunciosService;
    EmailService emailService;
    @Inject
    UsuarioResource usuarioResource;

    public void salvarUsuario(DTOUsuario usuarioDto){
        modelMapper = new ModelMapperUtil();
        _Usuario usuario = modelMapper.map(usuarioDto, (Type) _Usuario.class);
        usuario.setStatus(EnumStatus.INATIVO);
        usuarioResource.save(usuario);
//        emailService.enviarEmailConfirmacao(usuario);
    }

    public DTOUsuario atualizarUsuario(long idUsuario){
        return converterUsuario(usuarioResource.findById(idUsuario).get());
    }
    public DTOUsuario verificarUsuario(DTOLogin login) throws Exception{
                List<DTOUsuario> usuarioDto = new ArrayList<>();

        try {
            List<_Usuario> usuarioList = new ArrayList<>();
            usuarioResource.findAll().forEach(usuario -> {

                if (usuario.getEmail().equals(login.getUsuario()) && usuario.getSenha().equals(login.getSenha())) {
                    usuarioDto.add(converterUsuario(usuario));
                }
                if(usuario.getEmail().equals(login.getUsuario())&& !usuario.getSenha().equals(login.getSenha())){
                    usuarioList.add(usuario);
                }
            });
            if(usuarioDto.size()>0){
                return usuarioDto.get(0);
            }else {
                if(usuarioList.size()>0){
                    throw new WebApplicationException("Usuario ou senha invalida", 403);
                }
            }
        }catch (Exception e){
            throw new WebApplicationException("Usuario ou senha invalida", 403);
        }
       return usuarioDto.get(0);
    }

    public void editar(DTOUsuario usuarioDto){
        modelMapper = new ModelMapperUtil();
        _Usuario usuario = modelMapper.map(usuarioDto, (Type) _Usuario.class);
        usuarioResource.save(usuario);
    }

    public DTOUsuario converterUsuario(_Usuario usuario){
        DTOUsuario dtoUsuario = new DTOUsuario();
        dtoUsuario.setEmail(usuario.getEmail());
        dtoUsuario.setNome(usuario.getNome());
        dtoUsuario.setSobreNome(usuario.getSobreNome());
        dtoUsuario.setTelefone(usuario.getTelefone());
        dtoUsuario.setStatus(usuario.getStatus().getDescricao());
        dtoUsuario.setSenha(usuario.getSenha());
        dtoUsuario.setId(usuario.getId());
        dtoUsuario.setFavoritos(anunciosService.converterAnuncio(usuario.getFavoritos()));
        return dtoUsuario;
    }

}
