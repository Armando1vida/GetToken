/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ArmandoPC
 */
public class test {

    public static void main(String[] args) {
        Compilador c = new Compilador("22  + 1203.9");
        c.analzarLexico();
        c.MostarToken();
        c.analizadorSintactico();
    }

}
