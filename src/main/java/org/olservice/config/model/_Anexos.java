package org.olservice.config.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ANEXOS")
public class _Anexos implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String caminhoMidia;

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

    public String getCaminhoMidia() {
        return caminhoMidia;
    }

    public void setCaminhoMidia(String caminhoMidia) {
        this.caminhoMidia = caminhoMidia;
    }
}
