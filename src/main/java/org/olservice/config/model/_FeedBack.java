package org.olservice.config.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FEEDBACK")
public class _FeedBack  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "anuncio_id")
    private _Anuncio anuncio;

    private String usuario;
    private String descricao;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public _Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(_Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
