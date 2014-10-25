package modelo;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ArmandoPC
 */
public class Token {

    public static final int NUMERO = 0;
    public static final int OPERADOR_MAS = 1;
    public static final int OPERADOR_MENOS = 2;
    public static final int OPERADOR_MULT = 3;
    public static final int OPERADOR_DIV = 4;
    public static final int OTRO = 5;

    private String lexema;
    private int valor_token;

    public Token() {
    }

    public Token(String lexema, int valor_token) {
        this.lexema = lexema;
        this.valor_token = valor_token;
    }

    /**
     * @return the lexema
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * @param lexema the lexema to set
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    /**
     * @return the valor_token
     */
    public int getValor_token() {
        return valor_token;
    }

    /**
     * @param valor_token the valor_token to set
     */
    public void setValor_token(int valor_token) {
        this.valor_token = valor_token;
    }

}
