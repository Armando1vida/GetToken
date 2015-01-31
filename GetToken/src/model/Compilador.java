/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    DataCompiler dt;

    public Compilador(DataCompiler dts, String cadena) {
        this.dt = dts;
        this.cadena = cadena;
        lectura = new Lectura(cadena);
    }
//    public Compilador( String cadena) {
//        this.cadena = cadena;
//        lectura = new Lectura(cadena);
//    }

    public void analzarLexico() {
        lectura.setCad(cadena);
        String cad = lectura.getToken();
        int s;
        while (cad != null) {
            cad = cad.trim();
//            System.out.println(cad);
            if (cad.length() > 0) {
                s = this.dt.valueofCadEquals(cad);
//                System.out.println(cad + " = " + this.dt.valueofCadEquals(cad));
//                System.out.println(cad + " = " + this.dt.valueofCad(cad));
                if (s != 0) {// evaulo si coincide la cadena a nivel de cad.equals("ss")
                    listaToken.add(new Token(cad, s));
                } else { // evaluo la cadena a nivel de expresiones regulares
                    listaToken.add(new Token(cad, this.dt.valueofCad(cad)));
                }
            }
            cad = lectura.getToken();
        }
//        this.MostarToken();
    }

    public String analizadorSintactico(TablaTrans tabla) {
        int estado_actual = 0;
        for (int i = 0; i < listaToken.size(); i++) {
            estado_actual = Math.abs(estado_actual); // estado anterior
//            System.out.println(listaToken.get(i).getLexema());

            estado_actual = tabla.getEstadoSiguiente(estado_actual, listaToken.get(i).getValor_token());// estado siguiente
            if (estado_actual >= 1000) {
                return "Error";
            }
            if (estado_actual < 0 && i == listaToken.size() - 1) { // si el recorrido se efectuo con exito
                return "Correcto";
            }

        }
        if (estado_actual >= 0 && estado_actual < 1000) { // controla esto: 3+
            return "Error Sintáctico";
        }
        return "";
    }

    public String viewErros(TablaTrans tabla) {
        String result = "";
        int estado_actual = 0;
        for (int i = 0; i < listaToken.size(); i++) {
            estado_actual = Math.abs(estado_actual); // estado anterior
            estado_actual = tabla.getEstadoSiguiente(estado_actual, listaToken.get(i).getValor_token());// estado siguiente
            if (estado_actual >= 1000) {// cuando hay error
               return listaToken.get(i).getLexema() + "\n";
            }
            if (estado_actual < 0 && i == listaToken.size() - 1) { // si el recorrido se efectuo con exito
                return result;
            }
        }
        if (estado_actual >= 0 && estado_actual < 1000) { // controla esto: 3+
          return "Error Sintáctico" + "\n";

        }
        return result;
    }

    public void MostarToken() {
        for (Token token : this.listaToken) {
//            System.out.println(token.getLexema() + " => " + token.getValor_token());
        }
    }

    /**
     *
     * @return String
     */
    public String viewToken() {
        String s = "";
        for (Token token : this.listaToken) {
            s = s + token.getLexema() + " => " + dt.getLista().get(token.getValor_token()).getMatch() + "\n";
        }
        return s;
    }
}
