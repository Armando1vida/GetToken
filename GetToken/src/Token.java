/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.regex.Pattern;

/**
 *
 * @author Estudiante
 */
public class Token {

    private String cad;
    private Boolean haveToken;
    private String matchSring = "[a-zA-ZñÑ ]*";
    private String matchInt = "[0-9.]*";
    private String matchOperacion = "[*|/|+|-]";
    private String matchDouble = "[1|2|3|4|5|6|7|8|9|0|.]";
    private String matchValue;
    private Integer begin = 0;

    public Token(String cad) {
        this.cad = cad;
        this.haveToken = true;
        this.matchValue = this.matchSring;
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
        for (int x = this.getBegin(); x < this.getCad().length(); x++) {
            this.setBegin(x);
            if (Pattern.matches(this.getMatchValue(), this.getCad().charAt(x) + "")) {
                strreturn = strreturn + this.getCad().charAt(x);
            } else {
                if (this.getMatchValue().equals(this.getMatchSring())) {
                    this.setMatchValue(this.getMatchInt());
                    return strreturn;
                }
                if (this.getMatchValue().equals(this.getMatchInt())) {
                    this.setMatchValue(this.getMatchOperacion());
                    return strreturn;
                }
                if (this.getMatchValue().equals(this.getMatchOperacion())) {
                    this.setMatchValue(this.getMatchSring());
                    return strreturn;
                }
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
     * @return the matchDouble
     */
    public String getMatchDouble() {
        return matchDouble;
    }

    /**
     * @param matchDouble the matchDouble to set
     */
    public void setMatchDouble(String matchDouble) {
        this.matchDouble = matchDouble;
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

}
