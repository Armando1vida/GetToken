/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Estudiante
 */
public class Token {

    private String cad;
    private Boolean haveToken;
    private String matchSring = "[a-zA-ZñÑ]";
    private String matchInt = "[0-9.]";
    private String matchOperacion = "[*|/|+|-]";
    private String matchValue;
    private Integer begin = 0;

    ArrayList ListToken = new ArrayList();

    public static final int num = 0;
    public static final int string = 1;
    public static final int operador = 2;

    public Token(String cad) {
        this.cad = cad;
        this.haveToken = true;
        this.matchValue = this.matchInt;
    }

    /**
     * @return the cad
     */
    public String getCad() {
        return cad;
    }

    /**
     * @param cad the cad to set
     */
    public void setCad(String cad) {
        this.cad = cad;
    }

    /**
     * @return the token
     */
    public String getToken() {
        String strreturn = "";
        String chart = "";
        for (int x = this.getBegin(); x < this.getCad().length(); x++) {
            this.setBegin(x);
            chart = this.getCad().charAt(x) + "";
            if (!chart.equals(" ")) {
                if (Pattern.matches(this.getMatchValue(), chart)) {
                    strreturn = strreturn + this.getCad().charAt(x);
                } else {
                    if (this.getMatchValue().equals(this.getMatchSring())) {
                        this.setMatchValue(this.getMatchInt());
                        ListToken.add(new Nodo(strreturn, 1));
                        return strreturn;
                    }
                    if (this.getMatchValue().equals(this.getMatchInt())) {
                        this.setMatchValue(this.getMatchOperacion());
                        ListToken.add(new Nodo(strreturn, 0));
                        return strreturn;
                    }
                    if (this.getMatchValue().equals(this.getMatchOperacion())) {
                        this.setMatchValue(this.getMatchSring());
                        ListToken.add(new Nodo(strreturn, 2));
                        return strreturn;
                    }
                }

            } else {
                this.setBegin(x + 1);
                return strreturn;

            }

        }
        this.setHaveToken(false);
        return strreturn;
    }

    /**
     * @return the haveToken
     */
    public Boolean getHaveToken() {
        return haveToken;
    }

    /**
     * @param haveToken the haveToken to set
     */
    public void setHaveToken(Boolean haveToken) {
        this.haveToken = haveToken;
    }

    /**
     * @return the matchSring
     */
    public String getMatchSring() {
        return matchSring;
    }

    /**
     * @param matchSring the matchSring to set
     */
    public void setMatchSring(String matchSring) {
        this.matchSring = matchSring;
    }

    /**
     * @return the matchInt
     */
    public String getMatchInt() {
        return matchInt;
    }

    /**
     * @param matchInt the matchInt to set
     */
    public void setMatchInt(String matchInt) {
        this.matchInt = matchInt;
    }

    /**
     * @return the matchOperacion
     */
    public String getMatchOperacion() {
        return matchOperacion;
    }

    /**
     * @param matchOperacion the matchOperacion to set
     */
    public void setMatchOperacion(String matchOperacion) {
        this.matchOperacion = matchOperacion;
    }

    /**
     * @return the matchValue
     */
    public String getMatchValue() {
        return matchValue;
    }

    /**
     * @param matchValue the matchValue to set
     */
    public void setMatchValue(String matchValue) {
        this.matchValue = matchValue;
    }

    /**
     * @return the begin
     */
    public Integer getBegin() {
        return begin;
    }

    /**
     * @param begin the begin to set
     */
    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    /**
     * @return the begin
     */
    public Integer getValuen() {
        return begin;
    }

    public void imprimir() {
        for (int j = 0; j < ListToken.size(); j++) {//ahora imprimiremos las personas de nuestro ArrayList
            System.out.println("============================================================");
            Nodo persona = (Nodo) ListToken.get(j);
            System.out.println("Lexico: " + persona.getValor());
            System.out.println("Valor: " + persona.getDescripcion());
            System.out.println("============================================================");
        }
    }

}
