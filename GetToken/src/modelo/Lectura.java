/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Lectura {

    private String cad;
    private String matchSring = "[a-zA-ZñÑ]";
    private String matchNum = "[0-9.]";
    private String matchOperacion = "[^0-9|^A-Za-zÑñ|^ ]";
    private Integer begin = 0;

    public Lectura() {
    }

    public Lectura(String cad) {
        this.cad = cad;
        this.begin = 0;
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
        this.begin = 0;
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
     * @return the matchNum
     */
    public String getMatchNum() {
        return matchNum;
    }

    /**
     * @param matchNum the matchNum to set
     */
    public void setMatchNum(String matchNum) {
        this.matchNum = matchNum;
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

    public String getString() {
        String re = "";
        int x = this.getBegin();
        while (this.getBegin() < this.cad.length() && (this.cad.charAt(x) + "").matches(this.getMatchSring())) {

            re = re + this.cad.charAt(x++);
            this.setBegin(x);
        }
        return re.equals("") ? null : re;
    }

    public String getNumber() {
        String re = "";
        int x = this.getBegin();
        while (this.getBegin() < this.cad.length() && (this.cad.charAt(x) + "").matches(this.getMatchNum())) {
            re = re + this.cad.charAt(x++);
            this.setBegin(x);
        }
        return re.equals("") ? null : re;
    }

    public String getSymbol() {
        String re = "";
        int x = this.getBegin();
        if (x < this.cad.length() && (this.cad.charAt(x) + "").matches(this.getMatchOperacion())) {
            re = re + this.cad.charAt(x++);
            this.setBegin(x);
        }
        return re.equals("") ? null : re;
    }

    public String getToken() {
        String retorno = this.getNumber();
        if (retorno != null) {
            return retorno;
        }
        retorno = this.getString();
        if (retorno != null) {
            return retorno;
        }
        retorno = this.getSymbol();
        if (retorno != null) {
            return retorno;
        }

        if (this.getBegin() < this.cad.length() && this.cad.charAt(this.getBegin()) == ' ') {
            int d = this.getBegin();
            d = d + 1;
            this.setBegin(d);
            return this.getToken();
        }
        return null;
    }

}
