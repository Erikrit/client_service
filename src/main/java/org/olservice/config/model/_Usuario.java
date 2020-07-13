package org.olservice.config.model;

import org.olservice.config.Enum.EnumStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USUARIO")
public class _Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String sobreNome;

    private String email;

    private String senha;

    private EnumStatus status;

    private String telefone;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private List<_Anuncio> anuncios;

    @OneToOne
    private _Classificacao classificacao;

    @ManyToMany
    @JoinTable(name="favoritos",joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_anuncio"))
    private List<_Anuncio> favoritos;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
//    public List<_Anuncio> getAnuncios() {
//        return anuncios;
//    }
//
//    public void setAnuncios(List<_Anuncio> anuncios) {
//        this.anuncios = anuncios;
//    }

    public _Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(_Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public List<_Anuncio> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<_Anuncio> favoritos) {
        this.favoritos = favoritos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        _Usuario usuario = (_Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
