package org.olservice.config.dto;

public class DTOCategoria {

    private Long id;
    private String nome;
    private Long idCategoriaPai;
    private String icone;

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

    public Long getIdCategoriaPai() {
        return idCategoriaPai;
    }

    public void setIdCategoriaPai(Long idCategoriaPai) {
        this.idCategoriaPai = idCategoriaPai;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }
}
