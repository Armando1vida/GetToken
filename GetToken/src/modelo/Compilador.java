/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ArmandoPC
 */
public class Compilador {

    private String cadena;
    private Lectura lectura;
    private List<Token> listaToken = new ArrayList<>();

    public Compilador(String cadena) {
        this.cadena = cadena;

        lectura = new Lectura(cadena);
    }

    public void analzarLexico() {
        lectura.setCad(cadena);
        String cad = lectura.getToken();
        while (cad != null) {
            if (cad.matches("[0-9.]+")) {
                listaToken.add(new Token(cad, Token.NUMERO));
            } else if (cad.equals("+")) {
                listaToken.add(new Token(cad, Token.OPERADOR_MAS));
            } else if (cad.equals("-")) {
                listaToken.add(new Token(cad, Token.OPERADOR_MENOS));
            } else if (cad.equals("/")) {
                listaToken.add(new Token(cad, Token.OPERADOR_DIV));
            } else if (cad.equals("*")) {
                listaToken.add(new Token(cad, Token.OPERADOR_MULT));
            } else {
                listaToken.add(new Token(cad, Token.OTRO));
            }
            cad = lectura.getToken();
        }
    }

    public void analizadorSintactico() {
        int estado_actual = 0;
        TablaTrans tabla = new TablaTrans();
        for (int i = 0; i < listaToken.size(); i++) {
            estado_actual = Math.abs(estado_actual);
            estado_actual = tabla.getEstadoSiguiente(estado_actual, listaToken.get(i).getValor_token());
            if (estado_actual >= 1000) {
                System.out.println("Errrroooorrr");
                break;
            }
            if (estado_actual < 0 && i == listaToken.size() - 1) {
                System.out.println("Correcto");
            }

        }
        if (estado_actual >= 0 && estado_actual < 1000) { // controla esto: 3+
            System.out.println("Error Sintactico");
        }
    }

    public void MostarToken() {
        for (Token token : this.listaToken) {
            System.out.println(token.getLexema() + " => " + token.getValor_token());

        }
    }
}
