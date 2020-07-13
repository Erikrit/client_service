//package org.olservice.config.model;
//
//import java.util.Objects;
//
//
//public class _Estado {
//
////    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String nome;
//
//    private String uf;
//
//    private String visivel = "false";
//
//    public String getVisivel() {
//        return visivel;
//    }
//
//    public void setVisivel(String visivel) {
//        this.visivel = visivel;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getUf() {
//        return uf;
//    }
//
//    public void setUf(String uf) {
//        this.uf = uf;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        _Estado estado = (_Estado) o;
//        return Objects.equals(id, estado.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//}
