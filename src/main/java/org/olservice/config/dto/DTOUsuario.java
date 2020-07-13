package org.olservice.config.dto;

import java.util.List;

public class DTOUsuario {


    private Long id;

    private String nome;

    private String sobreNome;

    private String email;

    private String senha;

    private String telefone;

    private String status;

    private List<DTOAnuncio> favoritos;

    public List<DTOAnuncio> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<DTOAnuncio> favoritos) {
        this.favoritos = favoritos;
    }

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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
