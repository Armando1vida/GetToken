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
public class test {

    public static void main(String[] args) {
////        CompiladorOld c = new CompiladorOld("22-1203.9");
////        c.analzarLexico();
////        c.MostarToken();
////        c.analizadorSintactico();
////        String d="^";
////        System.out.println(d.matches("\\^"));
        String d = ";";

        Boolean dd = d.matches(";");

        System.out.println(dd);
//        "[^0-9|^A-Za-zÑñ|^ |\\^]|[\\^]"
    }

}
