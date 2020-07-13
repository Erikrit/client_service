package org.olservice.config.dto;

public class DTOFeedback {
    private Long idAnuncio;
    private String usuario;
    private String descricao;

   public DTOFeedback(){
   }
    public DTOFeedback(Long idAnuncio, String usuario, String descricao) {
        this.idAnuncio = idAnuncio;
        this.usuario = usuario;
        this.descricao = descricao;
    }

    public Long getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Long idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
