/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

/**
 *
 * @author ArmandoPC
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lectura1 l = new Lectura1();
        l.setCad("fore(String g: LLL)");

        String y = l.getToken();
        while (y != null) {
            System.out.println(y);
            y = l.getToken();
        }
        // TODO code application logic here
//        Compilador c = new Compilador("22");

//        c.MostarToken();
//        c.analzarLexico();
//        c.analizadorSintactico();
    }

}
