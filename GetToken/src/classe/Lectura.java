package classe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import .*;
//import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Estudiante
 */
public class Lectura {

    private String cad;
    private Boolean haveToken;
    public static String cadtmp;
    public static Character chartmp;

    private String matchSring = "[a-zA-ZñÑ]";
    public static final int string_name = 0;

    private String matchNum = "[0-9.]";
    public static final int num_name = 1;

    private String matchOperacion = "[^0-9|^A-Za-zÑñ|^ ]";
    public static final int operador_name = 2;

    private String matchValue;
    private Integer begin = 0;

//    ArrayList<Nodo> ListToken = new ArrayList();
    public Lectura(String cad) {
        this.cad = cad;
        this.haveToken = true;
        this.matchValue = this.matchSring;
    }

    public Lectura() {
        this.cad = "";
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
        cadtmp = null;
        for (int x = this.getBegin(); x < this.getCad().length(); x++) {
            chartmp = this.getCad().charAt(x);
            this.setBegin(x);
            if (chartmp != ' ') {
                if (Pattern.matches(this.getMatchValue(), chartmp + "")) {
                    cadtmp = cadtmp + chartmp;
                    if (this.getMatchValue().equals(this.getMatchOperacion())) {
                        this.setBegin(x + 1);
//                        ListToken.add(new Nodo(cadtmp, this.getMatchName(this.getMatchValue())));
                        return cadtmp;
                    }
                } else {
//                    if (!cadtmp.equals("")) {
////                        ListToken.add(new Nodo(cadtmp, this.getMatchName(this.getMatchValue())));
//                    }
                    this.changeMatchValue(chartmp);
                    return cadtmp;
                }

            } else {
//                if (!cadtmp.equals("")) {
////                    ListToken.add(new Nodo(cadtmp, this.getMatchName(this.getMatchValue())));
//                }
                this.setBegin(x + 1);
                return cadtmp;
            }

        }
//        if (!cadtmp.equals("")) {
////            ListToken.add(new Nodo(cadtmp, this.getMatchName(this.getMatchValue())));
//        }
        this.setHaveToken(false);
        return cadtmp;
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
    public String getMatchNum() {
        return matchNum;
    }

    /**
     * @param matchNum
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
     * @param matchvalue
     * @return the begin
     */
    public Integer getMatchName(String matchvalue) {
        if (this.getMatchSring().equals(matchvalue)) {
            return string_name;
        }
        if (this.getMatchNum().equals(matchvalue)) {
            return num_name;
        }
        if (this.getMatchOperacion().equals(matchvalue)) {
            return operador_name;
        }
        return begin;
    }

    /**
     * @param c
     * @return
     */
    public String changeMatchValue(Character c) {
        if (Pattern.matches(this.getMatchSring(), c + "")) {
            this.setMatchValue(this.getMatchSring());
        }
        if (Pattern.matches(this.getMatchNum(), c + "")) {
            this.setMatchValue(this.getMatchNum());
        }
        if (Pattern.matches(this.getMatchOperacion(), c + "")) {
            this.setMatchValue(this.getMatchOperacion());
        }
        return this.getMatchValue();
    }

//    public void imprimir() {
//        for (int j = 0; j < ListToken.size(); j++) {//ahora imprimiremos las personas de nuestro ArrayList
//            System.out.println("============================================================");
//            Nodo persona = (Nodo) ListToken.get(j);
//            System.out.println("Lexico: " + persona.getValor());
//            System.out.println("Valor: " + persona.getDescripcion());
//            System.out.println("============================================================");
//        }
//    }
}
