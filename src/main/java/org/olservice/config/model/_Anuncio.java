package org.olservice.config.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "ANUNCIO")
public class _Anuncio  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = ALL, mappedBy = "anuncio")
    private List<_FeedBack> feedBack;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private _Usuario usuario;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "imagem_id")
    private  _Imagem imagem;
    private String titulo;
    private String descricao;
    private String estado;
    private String cidade;
    @OneToOne()
    @JoinColumn(name = "categoria_id")
    private _Categoria categoria;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "referencia_id")
    private _Referencia referencia;
    private String valor;
    private String diasAtendimento;
    private String horaInicial;
    private String horaFim;
    private LocalDateTime dataAnuncio;

    public _Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(_Categoria categoria) {
        this.categoria = categoria;
    }

    public _Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(_Usuario usuario) {
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

    public LocalDateTime getDataAnuncio() {
        return dataAnuncio;
    }

    public void setDataAnuncio(LocalDateTime dataAnuncio) {
        this.dataAnuncio = dataAnuncio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<_FeedBack> getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(List<_FeedBack> feedBack) {
        this.feedBack = feedBack;
    }
//
//    public _Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(_Usuario usuario) {
//        this.usuario = usuario;
//    }

    public _Imagem getImagem() {
        return imagem;
    }

    public void setImagem(_Imagem imagem) {
        this.imagem = imagem;
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

//    public _Categoria getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(_Categoria categoria) {
//        this.categoria = categoria;
//    }

    public _Referencia getReferencia() {
        return referencia;
    }

    public void setReferencia(_Referencia referencia) {
        this.referencia = referencia;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
