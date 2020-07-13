package org.olservice.config.dto;

import java.util.List;

public class DTOAnuncio {
    private Long    id;
    private String titulo;
    private String descricao;
    private DTOCategoria categoria;
    private String estado;
    private String cidade;
    private String valor;
    private List<DTOImagem> imagens;
    private DTOReferencia referencia;
    private String diasAtendimento;
    private String horaInicial;
    private String horaFim;
    private DTOUsuario usuario;
    private List<DTOFeedback> feedback;

    public DTOAnuncio(){}

    public DTOAnuncio(Long id,String titulo, String descricao, String estado, String cidade, String valor, List<DTOImagem> imagens, DTOReferencia referencia, String diasAtendimento, String horaInicial, String horaFim,DTOUsuario usuario,DTOCategoria categoria,List<DTOFeedback> feedback) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.estado = estado;
        this.cidade = cidade;
        this.valor = valor;
        this.imagens = imagens;
        this.referencia = referencia;
        this.diasAtendimento = diasAtendimento;
        this.horaInicial = horaInicial;
        this.horaFim = horaFim;
        this.usuario = usuario;
        this.categoria = categoria;
        this.feedback = feedback;
    }

    public List<DTOFeedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<DTOFeedback> feedback) {
        this.feedback = feedback;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DTOCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(DTOCategoria categoria) {
        this.categoria = categoria;
    }

    public DTOUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(DTOUsuario usuario) {
        this.usuario = usuario;
    }

    public String getDiasAtendimento() {
        return diasAtendimento;
    }

    public void setDiasAtendimento(String diasAtendimento) {
        this.diasAtendimento = diasAtendimento;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public List<DTOImagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<DTOImagem> imagens) {
        this.imagens = imagens;
    }

    public DTOReferencia getReferencia() {
        return referencia;
    }

    public void setReferencia(DTOReferencia referencia) {
        this.referencia = referencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

//    public Long getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(Long categoria) {
//        this.categoria = categoria;
//    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
