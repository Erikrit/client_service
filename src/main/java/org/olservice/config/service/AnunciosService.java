package org.olservice.config.service;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.*;
import org.olservice.config.dto.*;
import org.olservice.config.mapper.ModelMapperUtil;
import org.olservice.config.model.*;
import org.olservice.config.resource.AnuncioResource;
import org.olservice.config.resource.UsuarioResource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class AnunciosService {
    @Inject
    public EntityManager em;
    ModelMapperUtil modelMapper;

    @Inject
    AnuncioResource anuncioResource;

    @Inject
    UsuarioResource usuarioResource;

    public void salvarAnuncio(DTOAnuncio anuncioDto) throws IOException, DbxException {
        String tokenDrobox = "0xr3QHVQX8AAAAAAAAAAFEGZJkUEKpPqSeH2NoQYrc3KFZtlygEyZoMVZDk8uQBG";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/service_client").build();
        DbxClientV2 client = new DbxClientV2(config, tokenDrobox);
        modelMapper = new ModelMapperUtil();
        _Anuncio anuncio = modelMapper.map(anuncioDto, (Type) _Anuncio.class);
        anuncio.setDataAnuncio(LocalDateTime.now());
        anuncioResource.save(anuncio);
       String caminho = client.files().createFolderV2("/ImagensApp/"+anuncio.getId()).getMetadata().getPathLower();
        anuncioDto.getImagens().forEach(dtoImagem -> {
            dtoImagem.setMidia(dtoImagem.getMidia().replace("data:image/jpeg;base64,", ""));
            byte[] imagemDecode = Base64.getDecoder().decode(dtoImagem.getMidia());
            try {
                InputStream imagem = new ByteArrayInputStream(imagemDecode);
                client.files().uploadBuilder(caminho+"/"+dtoImagem.getNome()+anuncio.getId()+".jpeg").
                        uploadAndFinish(imagem);
            } catch (IOException | DbxException e) {
                e.printStackTrace();
            }
        });
        anuncio.setImagem(new _Imagem());
        anuncio.getImagem().setCaminhoMidia(caminho);
        anuncioResource.save(anuncio);

    }
   public void salvarFavoritos(DTOFavorito favorito){
        Optional<_Usuario> usuario = usuarioResource.findById(favorito.getIdUsuario());
        Optional<_Anuncio> anuncio = anuncioResource.findById(favorito.getIdAnuncio());
       if(usuario.get().getFavoritos()==null) {
           usuario.get().setFavoritos(new ArrayList<>());
       }
       usuario.get().getFavoritos().add(anuncio.get());
       usuarioResource.save(usuario.get());
         }

    public List<DTOAnuncio> buscarAnuncio() {
        return converterAnuncio(anuncioResource.findAll());
    }

    public List<DTOImagem> carregarImagens(String caminho) throws IOException, DbxException {
        String tokenDrobox = "0xr3QHVQX8AAAAAAAAAAFEGZJkUEKpPqSeH2NoQYrc3KFZtlygEyZoMVZDk8uQBG";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/service_client").build();
        DbxClientV2 client = new DbxClientV2(config, tokenDrobox);
        ListFolderResult result = client.files().listFolder(caminho);
        List<DTOImagem> listDto = new ArrayList<>();

            for (Metadata metadata : result.getEntries()) {
                DTOImagem dtoImagem = new DTOImagem();
                DbxDownloader<FileMetadata> downloadBuilder= client.files().downloadBuilder(metadata.getPathLower()).start();
                InputStream imagem = downloadBuilder.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = imagem.read(buf)) != -1; ) {
                    //Writes to this byte array output stream
                    bos.write(buf, 0, readNum);
                }
                dtoImagem.setMidia("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(bos.toByteArray()));
                listDto.add(dtoImagem);
            }
        return listDto;
    }


    public void salvarComentario(DTOFeedback feedbackDto){
        modelMapper = new ModelMapperUtil();
        Optional<_Anuncio> anuncio = anuncioResource.findById(feedbackDto.getIdAnuncio());
        _FeedBack feedBack = modelMapper.map(feedbackDto, (Type) _FeedBack.class);
            if(anuncio.get().getFeedBack()==null) {
                anuncio.get().setFeedBack(new ArrayList<>());
            }
            anuncio.get().getFeedBack().add(feedBack);
        anuncioResource.save(anuncio.get());
    }

    public DTOReferencia converteDtoReferencia(_Referencia referencia) {
        DTOReferencia dtoReferencia = new DTOReferencia();
        dtoReferencia.setTelefone(referencia.getTelefone());
        dtoReferencia.setNome(referencia.getNome());
        return dtoReferencia;
    }

    public List<DTOAnuncio> converterAnuncio(List<_Anuncio> anuncios) {
        return anuncios.stream().map(anuncioDto ->
        {
            try {
                return new DTOAnuncio(anuncioDto.getId(),anuncioDto.getTitulo(), anuncioDto.getDescricao(), anuncioDto.getEstado(), anuncioDto.getCidade(),
                        String.valueOf(anuncioDto.getValor()), carregarImagens(anuncioDto.getImagem().getCaminhoMidia()),
                        converteDtoReferencia(anuncioDto.getReferencia()), anuncioDto.getDiasAtendimento(),
                        anuncioDto.getHoraInicial(), anuncioDto.getHoraFim(), converterUsuario(anuncioDto.getUsuario()),
                        converterCategoria(anuncioDto.getCategoria()),anuncioDto.getFeedBack().stream().map(feedBack -> new DTOFeedback(feedBack.getAnuncio().getId(),feedBack.getUsuario(),feedBack.getDescricao())).collect(Collectors.toList()));
            } catch (IOException | DbxException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }

    public DTOUsuario converterUsuario(_Usuario usuario) {
        DTOUsuario dtoUsuario = new DTOUsuario();
        dtoUsuario.setEmail(usuario.getEmail());
        dtoUsuario.setNome(usuario.getNome());
        dtoUsuario.setSobreNome(usuario.getSobreNome());
        dtoUsuario.setTelefone(usuario.getTelefone());
        dtoUsuario.setStatus(usuario.getStatus().getDescricao());
        dtoUsuario.setSenha(usuario.getSenha());
        dtoUsuario.setId(usuario.getId());
        return dtoUsuario;
    }


    public DTOCategoria converterCategoria(_Categoria categoria) {
        DTOCategoria dtoCategorio = new DTOCategoria();
        dtoCategorio.setId(categoria.getId());
        dtoCategorio.setIcone(categoria.getIcone());
        dtoCategorio.setIdCategoriaPai(categoria.getIdCategoriaPai());
        dtoCategorio.setNome(categoria.getNome());
        return dtoCategorio;
    }

    public List<DTOAnuncio> buscarComFiltro2(DTOFiltro2 filtro) {
        int resultadoFiltro = verificarfiltro2(filtro);
        if(resultadoFiltro==1){
            return converterAnuncio(anuncioResource.findAll().stream().filter(anuncio -> (filtro.getCategoria()==anuncio.getCategoria().getIdCategoriaPai() &&
                    filtro.getRegiao().equals(anuncio.getCidade()))||(filtro.getRegiao().equals(anuncio.getEstado())&& filtro.getCategoria()==anuncio.getCategoria().getIdCategoriaPai())).collect(Collectors.toList()));

        }else{
            if(resultadoFiltro==2) {
                return converterAnuncio(anuncioResource.findAll().stream().filter(anuncio -> filtro.getCategoria() == anuncio.getCategoria().getId()||filtro.getCategoria()==anuncio.getCategoria().getIdCategoriaPai()).collect(Collectors.toList()));
            }
            if(resultadoFiltro==3) {
                return converterAnuncio(anuncioResource.findAll().stream().filter(anuncio -> filtro.getRegiao().equals(anuncio.getCidade())||filtro.getRegiao().equals(anuncio.getEstado())).collect(Collectors.toList()));
            }
            if(resultadoFiltro==0) {
                return converterAnuncio(anuncioResource.findAll());
            }
        }
        return null;
    }
//    public DTOAnuncio filtrar(DTOFiltro filtro){
//        int resultado  = verificarFiltro(filtro);
//        if(filtro.getFiltro2()!=null){
//            int resultadoFiltro2 = verificarfiltro2(filtro.getFiltro2());
//        }
//        if()
//    }

    @Transactional
    public List<DTOAnuncio> meusAnuncios(int idUsuario) {

        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<_Anuncio> query = criteria.createQuery(_Anuncio.class);
        Root<_Anuncio> root = query.from(_Anuncio.class);

        query.select(root).where(criteria.equal(root.get(_Anuncio_.USUARIO), idUsuario));
        List<DTOAnuncio> anunciosList = converterAnuncio(em.createQuery(query).getResultList());

        return anunciosList;
    }


        public List<DTOAnuncio> buscarFeedback(int idUsuario){
            CriteriaBuilder criteria = em.getCriteriaBuilder();
            CriteriaQuery<_Anuncio> query = criteria.createQuery(_Anuncio.class);
            Root<_Anuncio> root = query.from(_Anuncio.class);

            query.select(root).where(criteria.equal(root.get(_Anuncio_.USUARIO), idUsuario));
            List<DTOAnuncio> anunciosList = converterAnuncio(em.createQuery(query).getResultList());

            return anunciosList.stream().filter(dtoAnuncio -> dtoAnuncio.getFeedback().size()>0 ).collect(Collectors.toList());

        }

    public int verificarfiltro2(DTOFiltro2 filtro2) {
        int resultadoFiltro = 0;
        if (filtro2.getCategoria() != null && filtro2.getRegiao() != null) {
            return resultadoFiltro = 1; //e s
            // inal que tem valor nos dois campos
        } else {
            if (filtro2.getCategoria() != null && filtro2.getRegiao()==null) {
                return resultadoFiltro = 2;
            }
            if (filtro2.getRegiao() != null && filtro2.getCategoria()==null) {
                return resultadoFiltro = 3;
            }
        }
        return resultadoFiltro;
    }
//    public int verificarFiltro(DTOFiltro filtro) {
//        int resultadoFiltro = 0;
//        int resultadoFiltro2=verificarfiltro2(filtro.getFiltro2());
//        int resultadoFinal =0;
//        if (filtro.getValorMaximo() != null && filtro.getValorMinimo() != null && filtro.getDisponibilidade()!=null) {
//            return resultadoFiltro = 1;
//        } else {
//            if (filtro.getValorMinimo() != null && filtro.getValorMaximo()==null ) {
//                return resultadoFiltro = 2;
//            }
//            if(filtro.getValorMinimo() == null && filtro.getValorMaximo()!=null){
//                return resultadoFiltro = 3;
//            }
//            if (filtro.getDisponibilidade()!= null) {
//                if(resultadoFiltro>0){
//                    return resultadoFiltro = 4;
//                }else{
//                    return resultadoFiltro = 5;
//                }
//
//            }
//        }
//        if(resultadoFiltro ==1 && resultadoFiltro2==1){
//            resultadoFinal =1;
//        }
//        if(resultadoFiltro ==1 && resultadoFiltro2==2){
//            resultadoFinal =2;
//        }
//        if(resultadoFiltro ==1 && resultadoFiltro2==3){
//            resultadoFinal =3;
//        }
//        if(resultadoFiltro ==2 && resultadoFiltro2==1){
//            resultadoFinal =4;
//        }
//        if(resultadoFiltro ==2 && resultadoFiltro2==2){
//            resultadoFinal =5;
//        }
//        if(resultadoFiltro ==2 && resultadoFiltro2==3){
//            resultadoFinal =6;
//        }
//        if(resultadoFiltro ==3 && resultadoFiltro2==1){
//            resultadoFinal =7;
//        }
//        if(resultadoFiltro ==3 && resultadoFiltro2==2){
//            resultadoFinal =8;
//        }
//        if(resultadoFiltro ==3 && resultadoFiltro2==3){
//            resultadoFinal =9;
//        }
//        if(resultadoFiltro ==4 && resultadoFiltro2==1){
//            resultadoFinal =10;
//        }
//        if(resultadoFiltro ==4 && resultadoFiltro2==2){
//            resultadoFinal =11;
//        }
//        if(resultadoFiltro ==4 && resultadoFiltro2==3){
//            resultadoFinal =12;
//        }
//        if(resultadoFiltro ==5 && resultadoFiltro2==1){
//            resultadoFinal =13;
//        }
//        if(resultadoFiltro ==5 && resultadoFiltro2==2){
//            resultadoFinal =14;
//        }
//        if(resultadoFiltro ==5 && resultadoFiltro2==3){
//            resultadoFinal =15;
//        }
//        return resultadoFiltro;
//    }
}
