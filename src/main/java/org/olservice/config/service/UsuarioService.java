package org.olservice.config.service;
import org.olservice.config.Enum.EnumStatus;
import org.olservice.config.dto.DTOLogin;
import org.olservice.config.dto.DTOUsuario;
import org.olservice.config.mapper.ModelMapperUtil;
import org.olservice.config.model._Usuario;
import org.olservice.config.resource.UsuarioResource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.lang.reflect.Type;
import java.util.Base64;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class UsuarioService {

    ModelMapperUtil modelMapper;
   static AnunciosService anunciosService = new AnunciosService();
    @Inject
    UsuarioResource usuarioResource;
    public void salvarUsuario(DTOUsuario usuarioDto){
        modelMapper = new ModelMapperUtil();
        usuarioDto.setSenha(criptografiaBase64Encoder(usuarioDto.getSenha()));
        _Usuario usuario = modelMapper.map(usuarioDto, (Type) _Usuario.class);
        usuario.setStatus(EnumStatus.INATIVO);
        usuarioResource.save(usuario);
//        emailService.enviarEmailConfirmacao(usuario);
    }

    public DTOUsuario atualizarUsuario(long idUsuario){
        return converterUsuario(usuarioResource.findById(idUsuario).get());
    }
    public DTOUsuario verificarUsuario(DTOLogin login){
        _Usuario usuarioBanco = buscarUsuarioFazendoLogin(login);
        if(usuarioBanco!=null){
            return converterUsuario(usuarioBanco);
        }else{
            throw new WebApplicationException("Usuario ou senha invalida", 403);
        }
    }

    public void editar(DTOUsuario usuarioDto){
        modelMapper = new ModelMapperUtil();
        _Usuario usuario = modelMapper.map(usuarioDto, (Type) _Usuario.class);
        usuarioResource.save(usuario);
    }

    public static DTOUsuario converterUsuario(_Usuario usuario){
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

    public static String criptografiaBase64Encoder(String valor) {
        return Base64.getEncoder().encodeToString(valor.getBytes());
    }

    public _Usuario buscarUsuarioFazendoLogin(DTOLogin usuarioLogin){
      return usuarioResource.findAll().stream().filter(usuario
                -> usuario.getEmail().equals(usuarioLogin.getEmail()) &&
                usuario.getSenha().equals(criptografiaBase64Encoder(usuarioLogin.getSenha()))).
                collect(Collectors.toList()).get(0);
    }

    public static String descriptografiaBase64Decoder(String valorCriptografado) {
        return new String(Base64.getDecoder().decode(valorCriptografado));
    }
}
