/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ArmandoPC
 */
public class ConstansToken {

    private String simbolo;
    private Integer valor;
    private String match;

    public ConstansToken() {
    }

    public ConstansToken(String simbolo, Integer valor, String match) {
        this.simbolo = simbolo;
        this.valor = valor;
        this.match = match;
    }

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * @return the valor
     */
    public Integer getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    /**
     * @return the macth
     */
    public String getMatch() {
        return match;
    }

    /**
     * @param macth the macth to set
     */
    public void setMatch(String macth) {
        this.match = macth;
    }

}
