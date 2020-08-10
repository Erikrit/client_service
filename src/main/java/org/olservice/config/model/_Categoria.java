package org.olservice.config.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORIA")
public class _Categoria  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "id_categoria_pai")
    private Long idCategoriaPai;
    @Column(name = "icone")
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
