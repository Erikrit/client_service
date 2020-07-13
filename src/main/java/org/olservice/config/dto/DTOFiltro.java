package org.olservice.config.dto;

public class DTOFiltro {


    private String disponibilidade;
    private String valorMinimo;
    private String valorMaximo;
    private DTOFiltro2 filtro2;

    public String getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(String valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(String valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public DTOFiltro2 getFiltro2() {
        return filtro2;
    }

    public void setFiltro2(DTOFiltro2 filtro2) {
        this.filtro2 = filtro2;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

}
