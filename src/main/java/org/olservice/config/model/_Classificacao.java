package org.olservice.config.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CLASSFICICACAO")
public class _Classificacao  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long pontos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPontos() {
        return pontos;
    }

    public void setPontos(Long pontos) {
        this.pontos = pontos;
    }
}
